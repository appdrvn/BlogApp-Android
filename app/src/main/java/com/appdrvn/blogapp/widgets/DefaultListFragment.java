package com.appdrvn.blogapp.widgets;

import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.paginate.Paginate;
import com.paginate.recycler.LoadingListItemSpanLookup;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by kelvynlaw on 02/11/16.
 */
public class DefaultListFragment extends DefaultFragment {
    public RecyclerView mRecyclerView;
    public SwipeRefreshLayout mSwipeRefreshLayout;
    public int mCurrentPage = 0;
    public boolean isLoadingMore = false;
    public boolean isLastPage = false;

    public void loadData() {

    }

    public Paginate.Callbacks paginationCallback = new Paginate.Callbacks() {
        @Override
        public void onLoadMore() {
            mCurrentPage++;
            isLoadingMore = true;
            loadData();
        }

        @Override
        public boolean isLoading() {
            // Indicate whether new page loading is in progress or not
            return isLoadingMore;
        }

        @Override
        public boolean hasLoadedAllItems() {
            // Indicate whether all data (pages) are loaded or not
            return isLastPage;
        }
    };

    public SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mCurrentPage = 0;
            loadData();
        }
    };

    public void setupLoadMore() {
        setupLoadMore(null, 1);
    }

    public void setupLoadMore(NestedScrollView scrollView) {
        setupLoadMore(scrollView, 1);

    }

    public void setupLoadMore(int spanSize) {
        setupLoadMore(null, spanSize);
    }

    public void setupLoadMore(NestedScrollView scrollView, final int spanSize) {
        if (scrollView != null) {
            Paginate.with(scrollView, mRecyclerView, paginationCallback)
                    .setLoadingTriggerThreshold(200)
                    .addLoadingListItem(true)
                    .setLoadingListItemCreator(null)
                    .setLoadingListItemSpanSizeLookup(new LoadingListItemSpanLookup() {
                        @Override
                        public int getSpanSize() {
                            return spanSize;
                        }
                    })
                    .build();
        } else {
            Paginate.with(mRecyclerView, paginationCallback)
                    .setLoadingTriggerThreshold(2)
                    .addLoadingListItem(true)
                    .setLoadingListItemCreator(null)
                    .setLoadingListItemSpanSizeLookup(new LoadingListItemSpanLookup() {
                        @Override
                        public int getSpanSize() {
                            return spanSize;
                        }
                    })
                    .build();
        }
    }
    public boolean showProgressDialog(){
        return !mSwipeRefreshLayout.isRefreshing() && !isLoadingMore;
    }
    public void finishLoading(){
        mSwipeRefreshLayout.setRefreshing(false);
        isLoadingMore = false;
    }

}

