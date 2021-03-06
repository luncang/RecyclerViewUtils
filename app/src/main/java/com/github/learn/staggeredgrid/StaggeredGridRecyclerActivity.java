package com.github.learn.staggeredgrid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.github.captain_miao.recyclerviewutils.WrapperRecyclerView;
import com.github.captain_miao.recyclerviewutils.common.DefaultLoadMoreFooterView;
import com.github.captain_miao.recyclerviewutils.listener.RefreshRecyclerViewListener;
import com.github.learn.refreshandload.R;

import java.util.ArrayList;


public class StaggeredGridRecyclerActivity extends AppCompatActivity implements RefreshRecyclerViewListener {

    private StaggeredGridAdapter mAdapter;
    private WrapperRecyclerView mWrapperRecyclerView;
    private final int MAX_ITEM_COUNT = 130;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_refresh_recycler_view);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        mWrapperRecyclerView = (WrapperRecyclerView) findViewById(R.id.recycler_view);
        final StaggeredGridLayoutManager LayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mWrapperRecyclerView.setLayoutManager(LayoutManager);
        mAdapter = new StaggeredGridAdapter(new ArrayList<String>());
        mAdapter.setLoadMoreFooterView(new DefaultLoadMoreFooterView(this));
        mWrapperRecyclerView.setAdapter(mAdapter);

        // TODO: 16/4/23 it's a bug
        //addHeaderView();
        //addFooterView();
        mWrapperRecyclerView.setRecyclerViewListener(this);

        mWrapperRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                mWrapperRecyclerView.autoRefresh();
            }
        });
    }

    private void addHeaderView() {
        View mRecyclerViewHeader = LayoutInflater.from(this).inflate(R.layout.recycler_view_header, null);
        mRecyclerViewHeader.findViewById(R.id.btn_header_change_color).setVisibility(View.GONE);
        mAdapter.addHeaderView(mRecyclerViewHeader, true);
    }

    private void addFooterView() {
        View mRecyclerViewHeader = LayoutInflater.from(this).inflate(R.layout.recycler_view_footer, null);
        mRecyclerViewHeader.findViewById(R.id.btn_footer_change_color).setVisibility(View.GONE);
        mAdapter.addFooterView(mRecyclerViewHeader, true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void initMockData(int count){
        int max = images.length;
        int start = mAdapter.getItemCount();
        for (int i = start; i < max && i < (start + count); i++) {
            mAdapter.add(images[i]);
        }
    }
    private void initMockData() {
        initMockData(20);
    }


    private String[] images = new String[]{
            "http://ww1.sinaimg.cn/small/7a8aed7bjw1f2sm0ns82hj20f00l8tb9.jpg",
            "http://img4.duitang.com/uploads/blog/201311/04/20131104193715_NCexN.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201408/09/20140809210610_iTSJx.thumb.jpeg",
            "http://ww2.sinaimg.cn/small/7a8aed7bjw1f340c8jrk4j20j60srgpf.jpg",
            "http://cdn.duitang.com/uploads/blog/201401/07/20140107223310_LH3Uy.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201405/09/20140509222156_kVexJ.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201306/14/20130614185903_raNR3.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201112/11/20111211191621_HU4Bj.thumb.jpg",
            "http://cdn.duitang.com/uploads/item/201408/07/20140807224553_VXaUc.thumb.jpeg",
            "http://ww4.sinaimg.cn/large/7a8aed7bjw1f2tpr3im0mj20f00l6q4o.jpg",
            "http://img5.duitang.com/uploads/blog/201407/29/20140729105929_GQLwC.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201408/04/20140804160432_LnFeB.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201408/04/20140804161101_JVJea.thumb.jpeg",
            "http://cdn.duitang.com/uploads/blog/201408/04/20140804093210_FxFNd.thumb.jpeg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f2uyg3nvq7j20gy0p6myx.jpg",
            "http://img5.duitang.com/uploads/blog/201408/04/20140804160314_hRKtv.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201408/01/20140801080524_SnGfE.thumb.jpeg",
            "http://ww2.sinaimg.cn/large/7a8aed7bjw1f2w0qujoecj20f00kzjtt.jpg",
            "http://img5.duitang.com/uploads/item/201407/23/20140723140958_NSWfE.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201407/22/20140722153305_WHejQ.thumb.jpeg",
            "http://ww3.sinaimg.cn/small/7a8aed7bjw1f2x7vxkj0uj20d10mi42r.jpg",
            "http://img5.duitang.com/uploads/item/201407/21/20140721010148_ZBQwe.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201407/23/20140723085122_cmteu.thumb.jpeg",
            "http://ww1.sinaimg.cn/large/7a8aed7bjw1f2zwrqkmwoj20f00lg0v7.jpg",
            "http://img5.duitang.com/uploads/item/201407/23/20140723130620_Z2yJB.thumb.jpeg",
            "http://cdn.duitang.com/uploads/blog/201407/20/20140720204738_NXxLE.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201407/20/20140720134916_VGfyh.thumb.jpeg",
            "http://ww2.sinaimg.cn/small/7a8aed7bjw1f30sgi3jf0j20iz0sg40a.jpg",
            "http://img5.duitang.com/uploads/blog/201407/17/20140717113117_mUssJ.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201407/17/20140717121501_wfFEm.thumb.jpeg",
            "http://ww4.sinaimg.cn/small/7a8aed7bjw1f32d0cumhkj20ey0mitbx.jpg",
            "http://img5.duitang.com/uploads/blog/201407/17/20140717121431_w4AV8.thumb.jpeg",
            "http://ww2.sinaimg.cn/large/610dc034gw1f35cxyferej20dw0i2789.jpg",
            "http://img5.duitang.com/uploads/blog/201407/17/20140717121918_TtJjY.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201407/11/20140711234806_FNLBQ.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201407/18/20140718121437_UyiAS.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201407/17/20140717114829_RiCXR.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201407/17/20140717120301_wGFYL.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201405/11/20140511121106_JXS4B.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201405/10/20140510094144_kfLji.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201405/09/20140509201906_kERjy.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201405/08/20140508193226_UaSGB.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201405/05/20140505201747_aPNtf.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201405/06/20140506104824_jPWQj.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201405/05/20140505201105_MkXdn.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201405/03/20140503205822_GCzta.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201405/03/20140503205535_cCHPB.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201405/03/20140503204354_xxSQX.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201404/06/20140406191307_GTxFd.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201404/06/20140406191247_BG2cU.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201404/06/20140406191114_MzYtw.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201404/06/20140406191127_fazJA.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201407/10/20140710081204_vYnCi.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201407/15/20140715133758_M2Y3J.thumb.jpeg",
            "http://img4.duitang.com/uploads/item/201407/13/20140713190806_TGJHm.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201407/05/20140705223413_5r3ze.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201407/13/20140713012526_tcy5u.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201407/13/20140713121424_Gy43T.thumb.jpeg",
            "http://img4.duitang.com/uploads/item/201407/15/20140715033844_tcvrY.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201407/10/20140710181106_4HHay.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201407/06/20140706122850_8PER3.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201407/07/20140707192042_8xKXF.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201407/07/20140707063954_mVa3y.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201407/08/20140708093733_AFFhc.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201407/07/20140707161220_unvzn.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201407/07/20140707113856_hBf3R.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201308/26/20130826090203_NtuYA.thumb.jpeg",
            "http://img4.duitang.com/uploads/item/201407/07/20140707145925_dHeKV.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/25/20140625101534_xiZxN.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201406/30/20140630150534_EWUVY.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/25/20140625121626_ZmT5n.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201307/31/20130731231806_4yGxV.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/28/20140628122218_fLQyP.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201406/26/20140626131831_MrdKP.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201406/16/20140616165201_nuKWj.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/25/20140625140308_KP4rn.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/25/20140625121604_2auuA.thumb.jpeg",
            "http://img4.duitang.com/uploads/item/201406/25/20140625131625_LmmLZ.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/25/20140625132851_mPmKY.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/25/20140625133312_ZtmW4.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/25/20140625164858_AuafS.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/24/20140624114145_e4iVw.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201406/25/20140625100427_Hkxj5.thumb.jpeg",
            "http://cdn.duitang.com/uploads/blog/201406/25/20140625213455_VHHcL.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/25/20140625132659_UuES4.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/24/20140624020050_zCE4U.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/18/20140618152533_dJjtW.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201406/20/20140620075216_twZE4.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/22/20140622162247_Z4WK4.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201406/20/20140620075158_TnyKU.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201406/18/20140618235506_5QJwc.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/18/20140618152515_AFcLy.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/03/20140603001954_NjKfX.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201405/31/20140531232042_4FkHQ.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201406/13/20140613002234_LHXcT.thumb.jpeg",
            "http://img4.duitang.com/uploads/item/201405/31/20140531231843_J5Euh.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/11/20140611220941_xBeyi.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/13/20140613114809_yuHRV.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201406/13/20140613120109_yL8hk.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201406/01/20140601185856_Q5jZr.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/06/20140606004724_GxQHQ.thumb.jpeg",
            "http://img4.duitang.com/uploads/item/201406/08/20140608003809_3JnEK.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/10/20140610085447_zeXJU.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201406/08/20140608193617_HyFrY.thumb.jpeg",
            "http://img4.duitang.com/uploads/item/201405/30/20140530190040_KQdsM.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201406/09/20140609101937_UBfJJ.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201406/10/20140610170410_cFhwW.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/09/20140609225334_PdGwG.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201406/09/20140609184438_e33i2.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201405/29/20140529200010_AfL8f.thumb.jpeg",
            "http://img4.duitang.com/uploads/blog/201406/08/20140608104649_KVtMx.thumb.png",
            "http://img5.duitang.com/uploads/item/201406/01/20140601215152_wi4wf.thumb.jpeg",
            "http://cdn.duitang.com/uploads/blog/201406/08/20140608194234_FEGkW.thumb.jpeg",
            "http://img4.duitang.com/uploads/item/201405/31/20140531221002_Awtv8.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/08/20140608091030_TJ3Cc.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201405/31/20140531221355_cSCTt.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201406/08/20140608005415_arBdK.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/08/20140608000002_2MTjn.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/03/20140603012613_z88sn.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201405/31/20140531221745_rnAzU.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201405/31/20140531220735_XBxFP.thumb.jpeg",
            "http://cdn.duitang.com/uploads/blog/201406/08/20140608194112_uEYf5.thumb.jpeg",
            "http://img5.duitang.com/uploads/blog/201406/08/20140608225626_xc2QT.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/07/20140607235759_sNS5Z.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201405/31/20140531220635_Lrw3w.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201406/08/20140608004245_jmBmP.thumb.jpeg",
            "http://img4.duitang.com/uploads/item/201406/08/20140608020213_SBfGH.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201406/08/20140608214105_kvVVY.thumb.jpeg",
            "http://img5.duitang.com/uploads/item/201406/03/20140603001556_XsMEv.thumb.jpeg",
            "http://cdn.duitang.com/uploads/item/201406/08/20140608024120_XjjGB.thumb.jpeg",
    };


    @Override
    public void onRefresh() {
        mWrapperRecyclerView.disableLoadMore();
        mWrapperRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mWrapperRecyclerView.refreshComplete();
                mWrapperRecyclerView.enableLoadMore();
                if(mAdapter.getItemCount() < 15) {
                    mAdapter.clear();
                    initMockData();
                } else {
                    mAdapter.clear();
                    initMockData(5);
                }
                mAdapter.hideFooterView();
                mAdapter.notifyDataSetChanged();
                mWrapperRecyclerView.getRecyclerView().scrollToPosition(0);
            }
        }, 500);
    }

    @Override
    public void onLoadMore(final int pagination, int pageSize) {
        mWrapperRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                if (mAdapter.getItemCount() < MAX_ITEM_COUNT) {
                    mAdapter.showLoadMoreView();
                } else {
                    mAdapter.showNoMoreDataView();
                }

            }
        });


        mWrapperRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {

                //int position = mAdapter.getItemCount();
                if (mAdapter.getItemCount() >= MAX_ITEM_COUNT) {
                    mAdapter.showNoMoreDataView();
                } else {
                    initMockData(5);
                    mAdapter.notifyDataSetChanged();
                    mAdapter.hideFooterView();
                }
                //java.lang.IndexOutOfBoundsException: Inconsistency detected. Invalid view holder adapter positionViewHolder
                //mAdapter.notifyItemRangeInserted(mAdapter.getItemCount() - 5, 5);
                //mRefreshRecyclerView.scrollToPosition(position);
                mWrapperRecyclerView.loadMoreComplete();
            }
        }, 1500);
    }
}
