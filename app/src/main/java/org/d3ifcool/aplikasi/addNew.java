package org.d3ifcool.aplikasi;

/**
 * Created by Nazmi on 11/03/2018.
 */

public class addNew {
    //For Title Of New List
    private String mJudul;
    //For Content Of New List
    private String mIsi;
    //For Date Of New List
    private String mDate;
    //For Priority Of New List
    private boolean mPrioritas;
    //Image resource ID for List
    private int mImage;

    // constructor for the new List object
    public addNew(String mJudul, String mIsi, String mDate, boolean mPrioritas, int mImage) {
        this.mJudul = mJudul;
        this.mIsi = mIsi;
        this.mDate = mDate;
        this.mPrioritas = mPrioritas;
        this.mImage = mImage;
    }

    public String getJudul() {
        return mJudul;
    }


    public String getmIsi() {
        return mIsi;
    }

    public String getmDate() {
        return mDate;
    }


    public boolean ismPrioritas() {
        return mPrioritas;
    }

    public int getmImage() { return mImage; }
}
