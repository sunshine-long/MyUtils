package com.unht.myutils.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.io.File;
import java.io.IOException;


/**
 * @author KangLong
 * @date 2017/5/9
 * @description CameraUtils用于调用系统相机 读取图片  剪切 保存到本地 申请相机权限等
 */

public class CameraUtils {
    private static final String TAG = "CameraUtils";
    //相机权限
    public static final int PERMISSION_RESQUEST_CODE = 300;
    //调用系统相机请求码
    public static final int GET_IMAGE_BY_CAMERA = 0;
    //打开本地图片请求码
    public static final int GET_IMAGE_FROM_PHONE = 1;
    //调用图片剪切请求码
    public static final int CROP_IMAGE = 2;
    //打开本地视频请求码
    public static final int OPEN_VIDEO = 3;
    //相机拍照后图片的的URI
    public static Uri imageUriFromCamera;
    //图片剪切后的URI
    public static Uri cropImageUri;
    // 文件存储目录
    public static String SAVED_IMAGE_DIR_PATH =
            Environment.getExternalStorageDirectory().getPath()
                    + "/imageRecognize/IMG";
    // 固定文件名
    private static String fileName;

    /**
     * 打开相机,拍照后返回存入URI
     *
     * @param thiz 调用activity
     */
    public static void openCameraImage(Activity thiz) {
        imageUriFromCamera = createImagePathUri(thiz);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUriFromCamera);
        thiz.startActivityForResult(intent, GET_IMAGE_BY_CAMERA);
    }

    public static void openCameraImage(Fragment thiz) {
        imageUriFromCamera = createImagePathUri(thiz.getActivity());
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUriFromCamera);
        thiz.startActivityForResult(intent, GET_IMAGE_BY_CAMERA);
    }

    /**
     * 打开相册,选择图片后返回URI
     *
     * @param thiz 调用activity
     */
    public static void openLocalImage(Activity thiz) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        thiz.startActivityForResult(intent, GET_IMAGE_FROM_PHONE);
    }

    public static void openLocalImage(Fragment thiz) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        thiz.startActivityForResult(intent, GET_IMAGE_FROM_PHONE);
    }

    /**
     * 调用系统剪切 剪切图片
     *
     * @param thiz    启动的activity
     * @param srcUri  剪切前图片的路径
     * @param outputX 剪切后图片的长
     * @param outputY 剪切后图片的宽
     */
    public static void cropImageSquare(Activity thiz, Uri srcUri, int outputX, int outputY) {
        cropImageUri = createImagePathUri(thiz);
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(srcUri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 2);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", outputX);
        intent.putExtra("outputY", outputY);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cropImageUri);
        intent.putExtra("return-data", false);
        thiz.startActivityForResult(intent, CROP_IMAGE);
    }

    public static void cropImageSquare(Fragment thiz, Uri srcUri, int outputXY) {
        cropImageUri = createImagePathUri(thiz.getActivity());
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(srcUri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", outputXY);
        intent.putExtra("outputY", outputXY);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cropImageUri);
        intent.putExtra("return-data", false);
        thiz.startActivityForResult(intent, CROP_IMAGE);
    }

    /**
     * 打开系统视频目录
     *
     * @param thiz 调用的activity
     */
    public static void openViedo(Activity thiz) {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        thiz.startActivityForResult(intent, OPEN_VIDEO);
    }

    /**
     * 通过时间创建图片URI
     *
     * @param context 启动相机的上下文
     * @return 图片的存储路径
     */
    public static Uri createImagePathUri(Context context) {
        Uri imageFilePath = null;
        File appDir = new File(SAVED_IMAGE_DIR_PATH);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            file.createNewFile();
            imageFilePath = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context.getApplicationContext(), "文件存储路径异常", Toast.LENGTH_SHORT).show();
        }
        return imageFilePath;
    }


    /**
     * 获取相机权限
     *
     * @param context 请求权限的上下文
     */
    public static void requestPermission(final Context context) {
        AndPermission.with(context).requestCode(PERMISSION_RESQUEST_CODE)
                .permission(Permission.STORAGE, Permission.CAMERA)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        // 此对话框可以自定义，调用rationale.resume()就可以继续申请。
                        AndPermission.rationaleDialog(context, rationale).show();
                    }
                }).callback(context)
                .start();
    }

    /**
     * 读取图片的旋转的角度
     *
     * @param path 图片绝对路径
     * @return 图片的旋转角度
     */
    private int getBitmapDegree(String path) {
        int degree = 0;
        try {
            // 从指定路径下读取图片，并获取其EXIF信息
            ExifInterface exifInterface = new ExifInterface(path);
            // 获取图片的旋转信息
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }


    /**
     * 将图片按照某个角度进行旋转
     *
     * @param bm     需要旋转的图片
     * @param degree 旋转角度
     * @return 旋转后的图片
     */
    public static Bitmap rotateBitmapByDegree(Bitmap bm, int degree) {
        Bitmap returnBm = null;

        // 根据旋转角度，生成旋转矩阵
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        try {
            // 将原始图片按照旋转矩阵进行旋转，并得到新的图片
            returnBm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
        }
        if (returnBm == null) {
            returnBm = bm;
        }
        if (bm != returnBm) {
            bm.recycle();
        }
        return returnBm;
    }


    /**
     * 启动Urop剪切图片
     *
     * @param activity       目标activity
     * @param sourceFilePath 剪切前图片的路径
     * @param requestCode    请求的code
     * @param aspectRatioX   剪切后图片的长
     * @param aspectRatioY   剪切后图片的宽
     * @return 剪切后图片的路径
     */
    public static String startUCrop(Activity activity, String sourceFilePath, int requestCode, float aspectRatioX, float aspectRatioY) {
        Uri sourceUri = Uri.fromFile(new File(sourceFilePath));
        File outDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!outDir.exists()) {
            outDir.mkdirs();
        }
        File outFile = new File(outDir, System.currentTimeMillis() + ".jpg");
        String cameraScalePath = outFile.getAbsolutePath();
        Uri destinationUri = Uri.fromFile(outFile);
        UCrop uCrop = UCrop.of(sourceUri, destinationUri);
        UCrop.Options options = new UCrop.Options();
        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        options.setHideBottomControls(true);
        options.setFreeStyleCropEnabled(true);
        uCrop.withOptions(options);
        uCrop.withAspectRatio(aspectRatioX, aspectRatioY);
        uCrop.start(activity, requestCode);
        return cameraScalePath;
    }

    /**
     * 配合Glide 实现将文件显示到ImageView，跳过转换成bitmap的过程
     * @param imageView 目标视图
     * @param file 图片文件
     */
    public static void setPicToView(Activity activity,ImageView imageView, File file) {
        Glide.with(activity).load(CameraUtils.cropImageUri).into(imageView);
    }

}
