package e.lengku8e.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
/**
 * HorizontalScrollView��ViewPager����Ч��
 * ����ΪHorizontalScrollView,����ΪViewPager
 * @author zj
 * 2012-5-23 ����1:07:06
 */
public class MainActivity1 extends Activity implements OnCheckedChangeListener{
	private RadioGroup mRadioGroup;
	private RadioButton mRadioButton1;
	private RadioButton mRadioButton2;
	private RadioButton mRadioButton3;
	private RadioButton mRadioButton4;
	private RadioButton mRadioButton5;
	private RadioButton mRadioButton6;
	private RadioButton mRadioButton7;
	private RadioButton mRadioButton8;
	private RadioButton mRadioButton9;
	
	private ImageView mImageView;
	private float mCurrentCheckedRadioLeft;//��ǰ��ѡ�е�RadioButton�������ľ���
	private HorizontalScrollView mHorizontalScrollView;//�����ˮƽ�����ؼ�
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        iniController();
        iniListener();
        
        mRadioButton1.setChecked(true);
        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();
        
    }
    /**
	 * RadioGroup���CheckedChanged����
	 */
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		
		AnimationSet _AnimationSet = new AnimationSet(true);
		TranslateAnimation _TranslateAnimation;
		
		Log.i("zj", "checkedid="+checkedId);
		if (checkedId == R.id.btn1) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo1), 0f, 0f);
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			mImageView.startAnimation(_AnimationSet);//��ʼ������ɫ����ͼƬ�Ķ����л�
		}else if (checkedId == R.id.btn2) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo2), 0f, 0f);

			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			mImageView.startAnimation(_AnimationSet);
		}else if (checkedId == R.id.btn3) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo3), 0f, 0f);
			
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			mImageView.startAnimation(_AnimationSet);
			
		}else if (checkedId == R.id.btn4) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo4), 0f, 0f);
			
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			mImageView.startAnimation(_AnimationSet);
		}else if (checkedId == R.id.btn5) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo5), 0f, 0f);
			
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			mImageView.startAnimation(_AnimationSet);
			
		}else if (checkedId == R.id.btn6) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo6), 0f, 0f);

			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			mImageView.startAnimation(_AnimationSet);
		}else if (checkedId == R.id.btn7) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo7), 0f, 0f);
			
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			mImageView.startAnimation(_AnimationSet);
			
		}else if (checkedId == R.id.btn8) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo8), 0f, 0f);
			
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			mImageView.startAnimation(_AnimationSet);
		}else if (checkedId == R.id.btn9) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo9), 0f, 0f);
			
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			mImageView.startAnimation(_AnimationSet);
			
		}
		
		mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();//���µ�ǰ��ɫ����������ߵľ���
		
		Log.i("zj", "getCurrentCheckedRadioLeft="+getCurrentCheckedRadioLeft());
		Log.i("zj", "getDimension="+getResources().getDimension(R.dimen.rdo2));
		
		mHorizontalScrollView.smoothScrollTo((int)mCurrentCheckedRadioLeft-(int)getResources().getDimension(R.dimen.rdo2), 0);
	}
    
	/**
     * ��õ�ǰ��ѡ�е�RadioButton�������ľ���
     */
	private float getCurrentCheckedRadioLeft() {
		// TODO Auto-generated method stub
		if (mRadioButton1.isChecked()) {
			return getResources().getDimension(R.dimen.rdo1);
		}else if (mRadioButton2.isChecked()) {
			return getResources().getDimension(R.dimen.rdo2);
		}else if (mRadioButton3.isChecked()) {
			return getResources().getDimension(R.dimen.rdo3);
		}else if (mRadioButton4.isChecked()) {
			return getResources().getDimension(R.dimen.rdo4);
		}else if (mRadioButton5.isChecked()) {
			return getResources().getDimension(R.dimen.rdo5);
		}else if (mRadioButton6.isChecked()) {
			return getResources().getDimension(R.dimen.rdo6);
		}else if (mRadioButton7.isChecked()) {
			return getResources().getDimension(R.dimen.rdo7);
		}
		else if (mRadioButton8.isChecked()) {
			return getResources().getDimension(R.dimen.rdo8);
		}
		else if (mRadioButton9.isChecked()) {
			return getResources().getDimension(R.dimen.rdo9);
		}
		
		return 0f;
	}

	private void iniListener() {
		// TODO Auto-generated method stub		
		mRadioGroup.setOnCheckedChangeListener(this);		
	}

	private void iniController() {
		// TODO Auto-generated method stub
		mRadioGroup = (RadioGroup)findViewById(R.id.radioGroup);
		mRadioButton1 = (RadioButton)findViewById(R.id.btn1);
		mRadioButton2 = (RadioButton)findViewById(R.id.btn2);
		mRadioButton3 = (RadioButton)findViewById(R.id.btn3);
		mRadioButton4 = (RadioButton)findViewById(R.id.btn4);
		mRadioButton5 = (RadioButton)findViewById(R.id.btn5);
		mRadioButton6 = (RadioButton)findViewById(R.id.btn6);
		mRadioButton7 = (RadioButton)findViewById(R.id.btn7);
		mRadioButton8 = (RadioButton)findViewById(R.id.btn8);
		mRadioButton9 = (RadioButton)findViewById(R.id.btn9);
		mImageView = (ImageView)findViewById(R.id.img1);		
		mHorizontalScrollView = (HorizontalScrollView)findViewById(R.id.horizontalScrollView);
		
	}

	
}