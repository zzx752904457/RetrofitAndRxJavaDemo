package com.rxjavademo.admin.retrofitandrxjavademo.base;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;


public abstract class MVPPresenter<V extends IMVPView>{

    protected Reference<V> mViewRef;    //view 接口类型的弱引用，防止内存泄露

    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }


    protected V getView() {
        return mViewRef == null ? null : mViewRef.get();
    }

    public boolean isViewAttach() {
        return mViewRef != null && mViewRef.get() != null;
    }

}
