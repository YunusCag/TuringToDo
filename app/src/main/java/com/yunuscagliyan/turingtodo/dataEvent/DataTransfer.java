package com.yunuscagliyan.turingtodo.dataEvent;

public class DataTransfer {

    public static class SplashHomeFragment{
        private int splashTimeOut;
        public SplashHomeFragment(int splashTimeOut) {
            this.splashTimeOut=splashTimeOut;
        }

        public int getSplashTimeOut() {
            return splashTimeOut;
        }

        public void setSplashTimeOut(int splashTimeOut) {
            this.splashTimeOut = splashTimeOut;
        }
    }


    public static class BoardingSplashFragment{
        private boolean showSplash;
        private int splashTimeOut;

        public BoardingSplashFragment(boolean showSplash,int splashTimeOut) {
            this.showSplash = showSplash;
            this.splashTimeOut=splashTimeOut;
        }

        public boolean isShowSplash() {
            return showSplash;
        }

        public void setShowSplash(boolean showSplash) {
            this.showSplash = showSplash;
        }
        public int getSplashTimeOut() {
            return splashTimeOut;
        }

        public void setSplashTimeOut(int splashTimeOut) {
            this.splashTimeOut = splashTimeOut;
    }


    }
}
