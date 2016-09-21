package com.ar.siosi.Hackfair;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by joyeongje on 2016. 9. 13..
 */
public class Comment implements Serializable {

    private int commentId;
    private int documentId;
    private String userId;
    private int content;
    private Date createDate;
    private int state;

    Comment() {

    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
