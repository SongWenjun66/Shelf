package com.song.frame.base;

import com.song.frame.config.ApiConfig;
import com.song.frame.config.RequestConfig;
import com.song.frame.interfaces.ICommonModule;
import com.song.frame.interfaces.ICommonView;

/**
 * SongWenjun
 * Created by dell
 * on 2019/10/1
 * The package is com.song.frame.base
 * This Class is ...
 */
public abstract class BaseRequestUtils<P extends BasePresenter, M extends ICommonModule> implements ICommonView {

    public M module;
    public P presenter;

    //开始请求
    public void startRequest() {
        presenter = createPresenter();
        module = createModule();

        presenter.attach(this, module);

        initView();
        initData();
    }

    protected void initData() {
    }

    protected void initView() {
    }

    protected abstract M createModule();

    protected abstract P createPresenter();

    public void distory() {
        if (presenter != null)
            presenter.dettach();
    }
}
