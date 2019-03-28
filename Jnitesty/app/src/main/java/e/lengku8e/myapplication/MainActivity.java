package e.lengku8e.myapplication;

import com.google.zxing.WriterException;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import karics.library.zxing.android.CaptureActivity;
import karics.library.zxing.encode.CodeCreator;

public class MainActivity extends Activity {

	private static final int REQUEST_CODE_SCAN = 0x0000;

	private static final String DECODED_CONTENT_KEY = "codedContent";
	private static final String DECODED_BITMAP_KEY = "codedBitmap";

	TextView qrCoded;
	ImageView qrCodeImage;
	Button creator, scanner, jumpOpenApi;
	EditText qrCodeUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		qrCoded = (TextView) findViewById(R.id.ECoder_title);
		qrCodeImage = (ImageView) findViewById(R.id.ECoder_image);
		creator = (Button) findViewById(R.id.ECoder_creator);
		scanner = (Button) findViewById(R.id.ECoder_scaning);
		qrCodeUrl = (EditText) findViewById(R.id.ECoder_input);
		jumpOpenApi = (Button) findViewById(R.id.jump_open_api);
		jumpOpenApi.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String url = qrCoded.getText().toString();
				String editUrl = qrCodeUrl.getText().toString();
				String jumpUrl = "";
				try {
					if (!TextUtils.isEmpty(editUrl)) {
						jumpUrl = editUrl;
					} else if (!TextUtils.isEmpty(url)) {
						jumpUrl = url;
					}
					Intent intent = new Intent();
					intent.setData(Uri.parse(jumpUrl));
					startActivity(intent);
				} catch (Exception e) {
//					Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
				}

			}
		});

		creator.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String url = qrCodeUrl.getText().toString();
				try {
					Bitmap bitmap = CodeCreator.createQRCode(url);
					qrCodeImage.setImageBitmap(bitmap);
				} catch (WriterException e) {
					e.printStackTrace();
				}

			}
		});

		scanner.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				requestReadPhonePermission(MainActivity.this);
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// 扫描二维码/条码回传
		if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
			if (data != null) {

				String content = data.getStringExtra(DECODED_CONTENT_KEY);
				Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);

				qrCoded.setText(content);
				qrCodeImage.setImageBitmap(bitmap);
			}
		}
	}
	private static final int REQUEST_CAMERA_CODE = 1001;


	private void requestReadPhonePermission(Activity activity) {
		if (Build.VERSION.SDK_INT >= 23) {
			if (activity != null) {
				if (activity.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager
						.PERMISSION_GRANTED) {

					if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
							(Manifest.permission.CAMERA))) {
						// 之前点击了“不再询问”，无法再次弹出权限申请框。
						// 去设置界面设置权限
						gotoSetPage(activity);
					} else {
						// 如果没有权限并且没勾选“不再询问”，向用户发起权限请求
						activity.requestPermissions(
								new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_CODE);

					}

				} else {
					goToCameraPage();
				}
			}
		} else {
			goToCameraPage();
		}
	}

	private void goToCameraPage() {
		Intent intent = new Intent(MainActivity.this,
				CaptureActivity.class);
		startActivityForResult(intent, REQUEST_CODE_SCAN);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		switch (requestCode) {
			case REQUEST_CAMERA_CODE: {
				if (grantResults == null || grantResults.length == 0) {
					return;
				}
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					// 权限被用户同意
					goToCameraPage();
				} else {
					gotoSetPage(MainActivity.this);
					Toast.makeText(this, "请开启拍照权限", Toast.LENGTH_LONG).show();
				}
				break;
			}
			default:
				break;
		}

	}

	private void gotoSetPage(Activity activity) {
		final Intent localIntent = new Intent();
		localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		if (Build.VERSION.SDK_INT >= 9) {
			localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
			localIntent.setData(Uri.fromParts("package", activity.getPackageName(), null));
		} else if (Build.VERSION.SDK_INT <= 8) {
			localIntent.setAction(Intent.ACTION_VIEW);
			localIntent.setClassName("com.android.settings",
					"com.android.settings.InstalledAppDetails");
			localIntent.putExtra("com.android.settings.ApplicationPkgName",
					activity.getPackageName());
		}
		activity.startActivity(localIntent);
	}
}
