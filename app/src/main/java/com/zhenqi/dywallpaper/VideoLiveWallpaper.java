package com.zhenqi.dywallpaper;

import android.media.MediaPlayer;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;

public class VideoLiveWallpaper extends WallpaperService {

    public Engine onCreateEngine() {
        return new VideoEngine();
    }

    class VideoEngine extends Engine {

        private MediaPlayer mMediaPlayer;

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            Log.e("CHEN", "onCreate");
            mMediaPlayer = new MediaPlayer();
        }

        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
            Log.e("CHEN", "onSurfaceCreated");
            mMediaPlayer.setSurface(holder.getSurface());
//            try {
//                AssetManager assetMg = getApplicationContext().getAssets();
//                AssetFileDescriptor fileDescriptor = assetMg.openFd("jiujiu.mp4");
//                mMediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(), fileDescriptor.getLength());
//                mMediaPlayer.setLooping(true);
//                mMediaPlayer.setVolume(0, 0);
//                mMediaPlayer.prepare();
//                mMediaPlayer.start();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
            Log.e("CHEN", "onSurfaceChanged");
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            Log.e("CHEN", "onVisibilityChanged");
            if (visible) {
                mMediaPlayer.start();
            } else {
                mMediaPlayer.pause();
            }
        }


        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            Log.e("CHEN", "onSurfaceDestroyed");
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}  