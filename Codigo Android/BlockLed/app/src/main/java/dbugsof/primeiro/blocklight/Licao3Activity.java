package dbugsof.primeiro.blocklight;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.blockly.android.AbstractBlocklyActivity;
import com.google.blockly.android.codegen.CodeGenerationRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dbugsof.primeiro.blocklight.MainActivity.connect;

/**
 * Created by filip on 07/11/2017.
 */

public class Licao3Activity extends AbstractBlocklyActivity {




    private static final List<String> JAVASCRIPT_GENERATORS = Arrays.asList();

    @NonNull
    @Override
    protected String getToolboxContentsXmlPath() {
        return "toolboxlivre.xml";
    }


    @NonNull
    @Override
    protected List<String> getBlockDefinitionsJsonPaths() {

        List<String> assetPaths = new ArrayList<>();
        assetPaths.add("colour_blocks.json");
        assetPaths.add("list_blocks.json");
        assetPaths.add("logic_blocks.json");
        assetPaths.add("loop_blocks.json");
        assetPaths.add("math_blocks.json");
        assetPaths.add("variable_blocks.json");
        // Append your own block definitions here.
        return assetPaths;
    }

    @NonNull
    @Override
    protected List<String> getGeneratorsJsPaths() {
        return JAVASCRIPT_GENERATORS;
    }



    private final Handler mHandler = new Handler();
    private WebView mTurtleWebview;
    private final CodeGenerationRequest.CodeGeneratorCallback mCodeGeneratorCallback =
            new CodeGenerationRequest.CodeGeneratorCallback() {
                @Override
                public void onFinishCodeGeneration(final String generatedCode) {
                    // Sample callback.
                    Log.i("oiiiiiiii", "generatedCode:\n" + generatedCode);
                    try {
                        Copilando copilando = new Copilando(getApplicationContext(),generatedCode,  0,0,0,0,0, MainActivity.connect );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getApplicationContext(), generatedCode,Toast.LENGTH_LONG).show();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                }
            };
    @NonNull
    @Override
    protected CodeGenerationRequest.CodeGeneratorCallback getCodeGenerationCallback() {
        return mCodeGeneratorCallback;
    }








}
