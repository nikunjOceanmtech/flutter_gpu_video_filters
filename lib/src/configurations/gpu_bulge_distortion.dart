part of flutter_gpu_video_filters;

class GPUBulgeDistortionConfiguration extends GPUFilterConfiguration {
  final PointParameter _center;
  final AspectRatioParameter _aspectRatio;
  final NumberParameter _radius;
  final NumberParameter _scale;

  GPUBulgeDistortionConfiguration()
      : _center = _PointParameter(
          'inputCenter',
          'Center',
          const Point(0.5, 0.5),
        ),
        _aspectRatio = _AspectRatioParameter(
          'inputAspectRatio',
          'Aspect Ratio',
          const Size(1.0, 1.0),
        ),
        _radius = _SliderFloatParameter(
          'inputRadius',
          'Radius',
          0.25,
          min: 0.0,
          max: 1.0,
        ),
        _scale = _SliderFloatParameter(
          'inputScale',
          'Scale',
          0.5,
          min: -1.0,
          max: 1.0,
        ),
        super('BulgeDistortion');

  set center(Point<double> value) {
    _center.value = value;
  }

  set aspectRatio(Size value) {
    _aspectRatio.value = value;
  }

  set radius(double value) {
    _radius.value = value;
  }

  set scale(double value) {
    _scale.value = value;
  }

  @override
  List<ConfigurationParameter> get parameters =>
      [_center, _aspectRatio, _radius, _scale];
}
