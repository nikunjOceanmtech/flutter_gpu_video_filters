part of flutter_gpu_video_filters;

mixin Sampling3x3Mixin on GPUFilterConfiguration {
  final NumberParameter _texelWidth = GLFloatParameter(
    'inputTexelWidth',
    'Texel Width',
    0.0,
  );

  final NumberParameter _texelHeight = GLFloatParameter(
    'inputTexelHeight',
    'Texel Height',
    0.0,
  );

  @override
  String get _previewVertex => 'VertexPreviewSampling3x3';

  @override
  String get _exportVertex => 'VertexSampling3x3';

  set texelWidth(double value) {
    _texelWidth.value = value;
  }

  set texelHeight(double value) {
    _texelHeight.value = value;
  }

  // coverage:ignore-start
  @override
  List<ConfigurationParameter> get parameters =>
      [...super.parameters, _texelHeight, _texelWidth];
// coverage:ignore-end
}
