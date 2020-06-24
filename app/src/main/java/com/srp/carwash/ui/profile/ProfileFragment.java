package com.srp.carwash.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;

import androidx.annotation.Nullable;

import com.nguyenhoanglam.imagepicker.model.Config;
import com.nguyenhoanglam.imagepicker.model.Image;
import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker;
import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentProfileBinding;
import com.srp.carwash.ui.about.AboutUsFragment;
import com.srp.carwash.ui.base.BaseFragment;
import com.srp.carwash.ui.checkout.CheckoutFragment;
import com.srp.carwash.ui.contact.ContactUsFragment;
import com.srp.carwash.ui.increase_credit.IncreaseCreditFragment;
import com.srp.carwash.ui.packages.PackagesFragment;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends BaseFragment<FragmentProfileBinding, ProfileFragmentViewModel> implements ProfileFragmentCallback {

    public static final String TAG = ProfileFragment.class.getSimpleName();

    @Inject
    ProfileFragmentViewModel mViewModel;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public int getBindingVariable() {
        return com.srp.carwash.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_profile;
    }

    @Override
    public ProfileFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void showMessage(String message) {
        showMessageToast(message);
    }

    @Override
    public void showMessage(int message) {
        showMessageToast(message);
    }

    @Override
    public void onBack() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void onEditProfile() {

    }

    @Override
    public void onContactUs() {
        changeFragmentNeedBack(R.id.fl_main, ContactUsFragment.newInstance(), ContactUsFragment.TAG);
    }

    @Override
    public void onAboutUs() {
        changeFragmentNeedBack(R.id.fl_main, AboutUsFragment.newInstance(), AboutUsFragment.TAG);
    }

    @Override
    public void onExtend() {
        changeFragmentNeedBack(R.id.fl_main, PackagesFragment.newInstance(), PackagesFragment.TAG);
    }

    @Override
    public void onCashOut() {
        changeFragmentNeedBack(R.id.fl_main, CheckoutFragment.newInstance(), CheckoutFragment.TAG);
    }

    @Override
    public void onIncreaseCredit() {
        changeFragmentNeedBack(R.id.fl_main, IncreaseCreditFragment.newInstance(), IncreaseCreditFragment.TAG);
    }

    @Override
    public void onExit() {
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 21) {
            getActivity().finishAffinity();
        } else if (Build.VERSION.SDK_INT >= 21) {
            getActivity().finishAndRemoveTask();
        }
    }

    @Override
    public void onAvatar() {
        ImagePicker.with(this)                         //  Initialize ImagePicker with activity or fragment context
                .setToolbarColor("#030611")         //  Toolbar color
                .setStatusBarColor("#000000")       //  StatusBar color (works with SDK >= 21  )
                .setToolbarTextColor("#ffffff")     //  Toolbar text color (Title and Done button)
                .setToolbarIconColor("#ffffff")     //  Toolbar icon color (Back and Camera button)
                .setProgressBarColor("#030611")     //  ProgressBar color
                .setBackgroundColor("#0C0D11")      //  Background color
                .setCameraOnly(false)               //  Camera mode
                .setMultipleMode(false)              //  Select multiple images or single image
                .setFolderMode(true)                //  Folder mode
                .setShowCamera(true)                //  Show camera button
                .setFolderTitle("آلبوم ها")           //  Folder title (works with FolderMode = true)
                .setImageTitle("گالری ها")         //  Image title (works with FolderMode = false)
                .setDoneTitle("ذخیره")               //  Max images can be selected
                .setRequestCode(100)                //  Set request code, default Config.RC_PICK_IMAGES
                .start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case UCrop.RESULT_ERROR:
                Throwable cropError = UCrop.getError(data);
                break;
            case UCrop.REQUEST_CROP:
                if (resultCode == RESULT_OK) {
                    Uri resultUri = UCrop.getOutput(data);
                    upload(new File(resultUri.getPath()));
                }
                break;
            case Config.RC_PICK_IMAGES:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<Image> images = data.getParcelableArrayListExtra(Config.EXTRA_IMAGES);
                    if (images.size() > 0) {
                        UCrop.Options options = new UCrop.Options();
                        options.setToolbarTitle("ویرایش تصویر");
                        options.setCircleDimmedLayer(true);
                        options.setToolbarColor(getResources().getColor(R.color.colorPrimaryDark));
                        options.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark2));
                        options.setCropFrameColor(getResources().getColor(R.color.light));
                        options.setToolbarWidgetColor(getResources().getColor(R.color.light));
                        options.setCropFrameStrokeWidth(1);
                        options.setCropGridColor(getResources().getColor(R.color.transparent));
                        options.setShowCropGrid(false);
                        final File file = new File(Environment.getExternalStorageDirectory(), "fall.jpg");
                        Uri uri = Uri.fromFile(file);
                        File dest = new File(uri.getPath());
                        UCrop.of(Uri.fromFile(new File(images.get(0).getPath())), Uri.fromFile(dest))
                                .withAspectRatio(7, 7)
                                .withMaxResultSize(500, 500)
                                .withOptions(options)
                                .start(getContext(), ProfileFragment.this);
                    }
                }
                break;
        }
    }

    @Override
    public void onStart() {
        try {
            mViewModel.doGetUserInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onStart();
    }

    private void upload(File file) {
        try {
            mViewModel.doUpload(getContext(), file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
