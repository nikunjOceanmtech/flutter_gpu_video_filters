part of flutter_gpu_video_filters;

class GPULaplacianConfiguration extends GPUFilterConfiguration
    with Sampling3x3Mixin {
  final Mat3Parameter _convolutionKernel;

  GPULaplacianConfiguration()
      : _convolutionKernel = _Mat3Parameter(
          'inputConvolutionMatrix',
          'Convolution Matrix',
          Mat3([0.5, 1.0, 0.5, 1.0, -6.0, 1.0, 0.5, 1.0, 0.5]),
        ),
        super('Laplacian');

  set convolutionKernel(Mat3 value) {
    _convolutionKernel.value = value;
  }

  @override
  List<ConfigurationParameter> get parameters =>
      [...super.parameters, _convolutionKernel];
}
