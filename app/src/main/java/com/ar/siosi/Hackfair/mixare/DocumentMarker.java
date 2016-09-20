package com.ar.siosi.Hackfair.mixare;

import android.graphics.Bitmap;
import android.location.Location;

import com.ar.siosi.Hackfair.Comment;
import com.ar.siosi.Hackfair.mixare.data.DataSource;
import com.ar.siosi.Hackfair.mixare.gui.PaintScreen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by joyeongje on 2016. 9. 20..
 */
public class DocumentMarker extends Marker {


    public static final int MAX_OBJECTS=50;
    private int documentType;
    private int documentPopularity;
    private int documentResponseWithme;
    private int documentResponseSeeyou;
    private int documentResponseNotgood;
    private int documentCommentNum;
    private int documentReadNum;
    private Date documentCreateDate;
    private Date documentUpdateDate;
    private List<Comment> commentList = new ArrayList<Comment>();

    public DocumentMarker(String title, double latitude, double longitude, double altitude, String link, DataSource.DATASOURCE datasource,int documentType,int documentPopularity,
                          int documentResponseWithme, int documentResponseSeeyou, int documentResponseNotgood, int documentCommentNum, int documentReadNum,
                          Date documentCreateDate,Date documentUpdateDate,List<Comment> commentList)

    {
        super(title, latitude, longitude, altitude, link, datasource);
        this.documentType = documentType;
        this.documentPopularity = documentPopularity;
        this.documentResponseWithme = documentResponseWithme;
        this.documentResponseSeeyou = documentResponseSeeyou;
        this.documentResponseNotgood = documentResponseNotgood;
        this.documentCommentNum = documentCommentNum;
        this.documentReadNum = documentReadNum;
        this.documentCreateDate = documentCreateDate;
        this.documentUpdateDate = documentUpdateDate;
        this.commentList = commentList;
    }

    // 마커 갱신
    @Override
    public void update(Location curGPSFix) {

        double altitude = curGPSFix.getAltitude()+Math.sin(0.35)*distance+Math.sin(0.4)*(distance/(MixView.dataView.getRadius()*1000f/distance));
        mGeoLoc.setAltitude(altitude - 0.2);
        super.update(curGPSFix);

    }

    // 페인트 스크린에 마커 출력
    @Override
    public void draw(PaintScreen dw) {

        // 텍스트 블록을 그린다
        drawTextBlock(dw,datasource);

        // 보여지는 상황이라면
        if (isVisible) {
            float maxHeight = Math.round(dw.getHeight() / 10f) + 1;	// 최대 높이 계산
            // 데이터 소스의 비트맵 파일을 읽어온다

            String markerFlag = "DOCUMENT";
            if(documentType == 0)
                markerFlag = "DOCUMENT";

            else if(documentType == 1)
                markerFlag = "IMAGE";

            else if(documentType == 2)
                markerFlag = "VIDEO";

            Bitmap bitmap = DataSource.getBitmap(markerFlag);

            // 비트맵 파일이 읽혔다면 적절한 위치에 출력
            if(bitmap!=null) {
                dw.paintBitmap(bitmap, cMarker.x - maxHeight/1.5f, cMarker.y - maxHeight/1.5f);
            }
            else {	// 비트맵 파일을 갖지 않는 마커의 경우
                dw.setStrokeWidth(maxHeight / 10f);
                dw.setFill(false);
                dw.setColor(DataSource.getColor(datasource));
                dw.paintCircle(cMarker.x, cMarker.y, maxHeight / 1.5f);
            }
        }
    }

    @Override
    public int getMaxObjects() {
        return MAX_OBJECTS;
    }

    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    public int getDocumentPopularity() {
        return documentPopularity;
    }

    public void setDocumentPopularity(int documentPopularity) {
        this.documentPopularity = documentPopularity;
    }

    public int getDocumentResponseWithme() {
        return documentResponseWithme;
    }

    public void setDocumentResponseWithme(int documentResponseWithme) {
        this.documentResponseWithme = documentResponseWithme;
    }

    public int getDocumentResponseSeeyou() {
        return documentResponseSeeyou;
    }

    public void setDocumentResponseSeeyou(int documentResponseSeeyou) {
        this.documentResponseSeeyou = documentResponseSeeyou;
    }

    public int getDocumentResponseNotgood() {
        return documentResponseNotgood;
    }

    public void setDocumentResponseNotgood(int documentResponseNotgood) {
        this.documentResponseNotgood = documentResponseNotgood;
    }

    public int getDocumentCommentNum() {
        return documentCommentNum;
    }

    public void setDocumentCommentNum(int documentCommentNum) {
        this.documentCommentNum = documentCommentNum;
    }

    public int getDocumentReadNum() {
        return documentReadNum;
    }

    public void setDocumentReadNum(int documentReadNum) {
        this.documentReadNum = documentReadNum;
    }

    public Date getDocumentCreateDate() {
        return documentCreateDate;
    }

    public void setDocumentCreateDate(Date documentCreateDate) {
        this.documentCreateDate = documentCreateDate;
    }

    public Date getDocumentUpdateDate() {
        return documentUpdateDate;
    }

    public void setDocumentUpdateDate(Date documentUpdateDate) {
        this.documentUpdateDate = documentUpdateDate;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
