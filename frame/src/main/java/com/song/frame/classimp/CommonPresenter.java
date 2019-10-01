package com.song.frame.classimp;

import com.song.frame.base.BasePresenter;
import com.song.frame.config.ApiConfig;
import com.song.frame.config.RequestConfig;
import com.song.frame.interfaces.ICommonPresenter;
import com.song.frame.interfaces.ICommonView;

/**
 * Song Wenjun
 * Created by dell on 2019/2/23 14:15
 * Created prepare
 * package is com.example.frame.classimp
 * <p>
 * This class is used to do:超级p层，万能p层
 */
public class CommonPresenter extends BasePresenter implements ICommonPresenter, ICommonView {
    @Override
    public void universalNode(RequestConfig refreshConfig, ApiConfig apiConfig, Object... t) {
        switch (refreshConfig) {
            case GET_DATA: {
                if (getModule() != null)
                    getModule().getData(this, refreshConfig, apiConfig, t);
            }
            break;
            case FORM_DATA: {
                if (getModule() != null)
                    getModule().fromData(this, refreshConfig, apiConfig, t);
            }
            break;
            case JSON_DATA: {
                if (getModule() != null)
                    getModule().jsonData(this, String.valueOf(t[1]), refreshConfig, apiConfig, t);
            }
            break;
            case POST_DATA: {
                if (getModule() != null)
                    getModule().postData(this, refreshConfig, apiConfig, t);
            }
            break;
            case FILE_COMMIT: {
                if (getModule() != null)
                    getModule().fileCommit(this, refreshConfig, apiConfig, t);
            }
            break;
        }
    }

    @Override
    public void onSuccess(RequestConfig refreshConfig, ApiConfig apiConfig, Object o) {
        if (getView() != null) {
            getView().onSuccess(refreshConfig, apiConfig, o);
        }
    }

    @Override
    public void onError(RequestConfig requestConfig, ApiConfig apiConfig, String e) {
        if (getView() != null) {
            getView().onError(requestConfig, apiConfig, e);
        }
    }
}
