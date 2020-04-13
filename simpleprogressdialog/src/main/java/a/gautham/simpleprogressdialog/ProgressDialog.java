package a.gautham.simpleprogressdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressDialog {

    private Dialog dialog;
    private TextView textView;
    private ProgressBar progressBar;
    private Activity activity;

    public ProgressDialog(Activity activity, String text) {
        dialog = new Dialog(activity);
        this.activity = activity;

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setCancelable(false);
        dialog.setContentView(R.layout.progress_dialog);

        textView = dialog.findViewById(R.id.text_progress);
        progressBar = dialog.findViewById(R.id.progress_circular);

        textView.setText(text);
    }

    public void showDialog(){
        dialog.show();
    }

    public void setTheme(int progressBarStyle){
        progressBar = new ProgressBar(new ContextThemeWrapper(activity, progressBarStyle));
    }

    public void updateText(String updateText){
        textView.setText(updateText);
    }

    public void hideDialog(){
        dialog.dismiss();
    }

    public boolean isDialogShowing(){
        return dialog.isShowing();
    }

}
