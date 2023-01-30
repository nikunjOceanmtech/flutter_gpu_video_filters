// Copyright 2022
// Autogenerated from Pigeon (v4.2.5), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package nd.flutter.plugins.gpu_video_filters;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class FilterMessages {
  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface FilterApi {
    @NonNull Long create(@NonNull String vertexShader, @NonNull String fragmentShader, @NonNull Map<String, Double> defaults);
    @NonNull Long exportVideoFile(@NonNull Long filterId, @NonNull Boolean asset, @NonNull String input, @NonNull String output, @NonNull String format);
    void setFloatParameter(@NonNull Long filterId, @NonNull String key, @NonNull Double value);
    void setFloatArrayParameter(@NonNull Long filterId, @NonNull String key, @NonNull List<Double> value);
    void setBitmapParameter(@NonNull Long filterId, @NonNull String key, @NonNull byte[] data);
    void setBitmapSourceParameter(@NonNull Long filterId, @NonNull String key, @NonNull Boolean asset, @NonNull String path);
    void dispose(@NonNull Long filterId);

    /** The codec used by FilterApi. */
    static MessageCodec<Object> getCodec() {
      return       new StandardMessageCodec();    }
    /**Sets up an instance of `FilterApi` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, FilterApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FilterApi.create", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              assert args != null;
              String vertexShaderArg = (String)args.get(0);
              if (vertexShaderArg == null) {
                throw new NullPointerException("vertexShaderArg unexpectedly null.");
              }
              String fragmentShaderArg = (String)args.get(1);
              if (fragmentShaderArg == null) {
                throw new NullPointerException("fragmentShaderArg unexpectedly null.");
              }
              Map<String, Double> defaultsArg = (Map<String, Double>)args.get(2);
              if (defaultsArg == null) {
                throw new NullPointerException("defaultsArg unexpectedly null.");
              }
              Long output = api.create(vertexShaderArg, fragmentShaderArg, defaultsArg);
              wrapped.put("result", output);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FilterApi.exportVideoFile", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              assert args != null;
              Number filterIdArg = (Number)args.get(0);
              if (filterIdArg == null) {
                throw new NullPointerException("filterIdArg unexpectedly null.");
              }
              Boolean assetArg = (Boolean)args.get(1);
              if (assetArg == null) {
                throw new NullPointerException("assetArg unexpectedly null.");
              }
              String inputArg = (String)args.get(2);
              if (inputArg == null) {
                throw new NullPointerException("inputArg unexpectedly null.");
              }
              String outputArg = (String)args.get(3);
              if (outputArg == null) {
                throw new NullPointerException("outputArg unexpectedly null.");
              }
              String formatArg = (String)args.get(4);
              if (formatArg == null) {
                throw new NullPointerException("formatArg unexpectedly null.");
              }
              Long output = api.exportVideoFile((filterIdArg == null) ? null : filterIdArg.longValue(), assetArg, inputArg, outputArg, formatArg);
              wrapped.put("result", output);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FilterApi.setFloatParameter", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              assert args != null;
              Number filterIdArg = (Number)args.get(0);
              if (filterIdArg == null) {
                throw new NullPointerException("filterIdArg unexpectedly null.");
              }
              String keyArg = (String)args.get(1);
              if (keyArg == null) {
                throw new NullPointerException("keyArg unexpectedly null.");
              }
              Double valueArg = (Double)args.get(2);
              if (valueArg == null) {
                throw new NullPointerException("valueArg unexpectedly null.");
              }
              api.setFloatParameter((filterIdArg == null) ? null : filterIdArg.longValue(), keyArg, valueArg);
              wrapped.put("result", null);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FilterApi.setFloatArrayParameter", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              assert args != null;
              Number filterIdArg = (Number)args.get(0);
              if (filterIdArg == null) {
                throw new NullPointerException("filterIdArg unexpectedly null.");
              }
              String keyArg = (String)args.get(1);
              if (keyArg == null) {
                throw new NullPointerException("keyArg unexpectedly null.");
              }
              List<Double> valueArg = (List<Double>)args.get(2);
              if (valueArg == null) {
                throw new NullPointerException("valueArg unexpectedly null.");
              }
              api.setFloatArrayParameter((filterIdArg == null) ? null : filterIdArg.longValue(), keyArg, valueArg);
              wrapped.put("result", null);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FilterApi.setBitmapParameter", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              assert args != null;
              Number filterIdArg = (Number)args.get(0);
              if (filterIdArg == null) {
                throw new NullPointerException("filterIdArg unexpectedly null.");
              }
              String keyArg = (String)args.get(1);
              if (keyArg == null) {
                throw new NullPointerException("keyArg unexpectedly null.");
              }
              byte[] dataArg = (byte[])args.get(2);
              if (dataArg == null) {
                throw new NullPointerException("dataArg unexpectedly null.");
              }
              api.setBitmapParameter((filterIdArg == null) ? null : filterIdArg.longValue(), keyArg, dataArg);
              wrapped.put("result", null);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FilterApi.setBitmapSourceParameter", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              assert args != null;
              Number filterIdArg = (Number)args.get(0);
              if (filterIdArg == null) {
                throw new NullPointerException("filterIdArg unexpectedly null.");
              }
              String keyArg = (String)args.get(1);
              if (keyArg == null) {
                throw new NullPointerException("keyArg unexpectedly null.");
              }
              Boolean assetArg = (Boolean)args.get(2);
              if (assetArg == null) {
                throw new NullPointerException("assetArg unexpectedly null.");
              }
              String pathArg = (String)args.get(3);
              if (pathArg == null) {
                throw new NullPointerException("pathArg unexpectedly null.");
              }
              api.setBitmapSourceParameter((filterIdArg == null) ? null : filterIdArg.longValue(), keyArg, assetArg, pathArg);
              wrapped.put("result", null);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FilterApi.dispose", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              assert args != null;
              Number filterIdArg = (Number)args.get(0);
              if (filterIdArg == null) {
                throw new NullPointerException("filterIdArg unexpectedly null.");
              }
              api.dispose((filterIdArg == null) ? null : filterIdArg.longValue());
              wrapped.put("result", null);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
  @NonNull private static Map<String, Object> wrapError(@NonNull Throwable exception) {
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", exception.getClass().getSimpleName());
    errorMap.put("details", "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    return errorMap;
  }
}
