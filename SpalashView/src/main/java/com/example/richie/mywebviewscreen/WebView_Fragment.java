package com.example.richie.mywebviewscreen;


import  android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


 public class WebView_Fragment extends Fragment {

    WebView myWebView;
    final static String myBlogAddr = "http://www.ahataxis.com";
    String myUrl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_view_, container, false);
        myWebView = (WebView) view.findViewById(R.id.webvw);

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new MyWebViewClient());

        if (myUrl == null) {
            myUrl = myBlogAddr;
        }
        myWebView.loadUrl(myUrl);

        return view;

    }



     private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            myUrl = url;
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }


}



