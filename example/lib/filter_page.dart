import 'dart:io';

import 'package:example/global.dart';
import 'package:flutter/material.dart';
import 'package:flutter_gpu_filters_interface/flutter_gpu_filters_interface.dart';
import 'package:flutter_gpu_video_filters/flutter_gpu_video_filters.dart';
import 'package:gallery_saver/gallery_saver.dart';
import 'package:image_picker/image_picker.dart';
import 'package:path_provider/path_provider.dart';

enum FilterType { color, image }

class FilterPage extends StatefulWidget {
  final FilterType filterType;
  const FilterPage({super.key, required this.filterType});

  @override
  State<FilterPage> createState() => _FilterPageState();
}

class _FilterPageState extends State<FilterPage> {
  bool previewParamsReady = false;
  static const _videoAsset = 'videos/video1.mp4';

  Future<void> _prepareColorFilter({required File file}) async {
    late GPURGBConfiguration configuration;
    Color colr = Colors.red;
    configuration = GPURGBConfiguration()
      ..red = colr.red.toDouble()
      ..blue = colr.blue.toDouble()
      ..green = colr.green.toDouble();
    await configuration.prepare();
    await GPUVideoPreviewParams.create(configuration);
    previewParamsReady = true;
    print("_exportVideo=============");
    _exportVideo(config: configuration, context: context, file: file).catchError(
      (e) => ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text(e.toString()))),
    );
  }

  Future<void> _prepareImageFilter({required File file}) async {
    GPUOverlayConfiguration configuration = GPUOverlayConfiguration()..image2Asset = 'images/effect3.png';
    await configuration.prepare();
    print("======+${configuration.parameters}");
    await GPUVideoPreviewParams.create(configuration);
    previewParamsReady = true;
    _exportVideo(config: configuration, context: context, file: file).catchError(
      (e) => ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text(e.toString()))),
    );
  }

  bool isLoading = false;
  String process1 = '';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('${widget.filterType.name} Preview'.toCamelcase())),
      body: Center(
        child: Stack(
          children: [
            ElevatedButton(
              onPressed: () async {
                ImagePicker picker = ImagePicker();
                XFile? xfile = await picker.pickVideo(source: ImageSource.gallery);
                if (xfile != null) {
                  if (widget.filterType == FilterType.color) {
                    await _prepareColorFilter(file: File(xfile.path)).whenComplete(() => setState(() {}));
                  } else if (widget.filterType == FilterType.image) {
                    await _prepareImageFilter(file: File(xfile.path)).whenComplete(() => setState(() {}));
                  }
                } else {
                  ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("Please Select video")));
                }
              },
              child: Text("Apply Filter"),
            ),
            isLoading
                ? Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      CircularProgressIndicator(),
                      Text(
                        process1,
                        textAlign: TextAlign.center,
                      ),
                    ],
                  )
                : const SizedBox.shrink()
          ],
        ),
      ),
    );
  }

  Future<void> _exportVideo({required config, required BuildContext context, required File file}) async {
    const asset = _videoAsset;
    final root = await getTemporaryDirectory();
    final output = File(
      '${root.path}/${DateTime.now().millisecondsSinceEpoch}.${asset.split('.').last}',
    );
    final watch = Stopwatch();
    watch.start();
    final processStream = config.exportVideoFile(
      VideoExportConfig(
        FileInputSource(file),
        output,
      ),
    );
    isLoading = true;
    setState(() {});
    await for (final progress in processStream) {
      debugPrint('_exportVideo: Exporting file ${(progress * 100).toInt()}%');
      process1 = '${(progress * 100).toInt()}%';
      setState(() {});
    }
    debugPrint('_exportVideo: Exporting file took ${watch.elapsed.inSeconds} Seconds');
    await GallerySaver.saveVideo(output.absolute.path);
    debugPrint('_exportVideo: Exported: ${output.absolute}');
    isLoading = false;
    setState(() {});
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(backgroundColor: Colors.green.shade700, content: Text("Video Save Success${output.path}")),
    );
  }
}
