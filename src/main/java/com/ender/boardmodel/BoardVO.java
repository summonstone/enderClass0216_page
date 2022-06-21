package com.ender.boardmodel;

import java.io.Serializable;

public class BoardVO implements Serializable {
	private int bo_num;
	private String bo_subject;
	private String bo_id;
	private String bo_content;
	private String bo_writer;
	private String bo_date;
	private int bo_readcount;
	private int bo_re_ref;
	private int bo_re_lev;
	private int bo_re_seq;
	private String part;
	private String searchData;
	private int page;
	private int limit;

	public final int getBo_re_ref() {
		return bo_re_ref;
	}

	public final void setBo_re_ref(int bo_re_ref) {
		this.bo_re_ref = bo_re_ref;
	}

	public final int getBo_re_lev() {
		return bo_re_lev;
	}

	public final void setBo_re_lev(int bo_re_lev) {
		this.bo_re_lev = bo_re_lev;
	}

	public final int getBo_re_seq() {
		return bo_re_seq;
	}

	public final void setBo_re_seq(int bo_re_seq) {
		this.bo_re_seq = bo_re_seq;
	}

	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int page, int limit) {
		super();
//		this.page = page;
		this.page = (page-1) * 10;
		this.limit = limit;

	}

	public final int getPage() {

		return page;
	}

	public final void setPage(int page) {
		this.page = page;
//		this.page = ((page - 1) / 10) * 10 + 1;
	}

	public final int getLimit() {
		return limit;
	}

	public final void setLimit(int limit) {
		this.limit = limit;
	}

	public BoardVO(String part, String searchData) {
		super();
		this.part = part;
		this.searchData = searchData;
	}

	public final String getPart() {
		return part;
	}

	public final void setPart(String part) {
		this.part = part;
	}

	public final String getSearchData() {
		return searchData;
	}

	public final void setSearchData(String searchData) {
		this.searchData = searchData;
	}

	public BoardVO(String bo_subject, String bo_id, String bo_content, String bo_writer) {
		super();
		this.bo_content = bo_content;
		this.bo_id = bo_id;
		this.bo_content = bo_content;
		this.bo_writer = bo_writer;

	}

	public BoardVO(int bo_num, String bo_subject, String bo_id, String bo_content, String bo_writer, String bo_date,
			int bo_readcount) {
		super();
		this.bo_num = bo_num;
		this.bo_subject = bo_subject;
		this.bo_id = bo_id;
		this.bo_content = bo_content;
		this.bo_writer = bo_writer;
		this.bo_date = bo_date;
		this.bo_readcount = bo_readcount;

	}

	public final int getBo_num() {
		return bo_num;
	}

	public final void setBo_num(int bo_num) {
		this.bo_num = bo_num;
	}

	public final String getBo_subject() {
		return bo_subject;
	}

	public final void setBo_subject(String bo_subject) {
		this.bo_subject = bo_subject;
	}

	public final String getBo_id() {
		return bo_id;
	}

	public final void setBo_id(String bo_id) {
		this.bo_id = bo_id;
	}

	public final String getBo_content() {
		return bo_content;
	}

	public final void setBo_content(String bo_content) {
		this.bo_content = bo_content;
	}

	public final String getBo_writer() {
		return bo_writer;
	}

	public final void setBo_writer(String bo_writer) {
		this.bo_writer = bo_writer;
	}

	public final String getBo_date() {
		return bo_date;
	}

	public final void setBo_date(String bo_date) {
		this.bo_date = bo_date;
	}

	public final int getBo_readcount() {
		return bo_readcount;
	}

	public final void setBo_readcount(int bo_readcount) {
		this.bo_readcount = bo_readcount;
	}

}
