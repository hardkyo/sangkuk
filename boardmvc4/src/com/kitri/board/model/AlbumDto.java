package com.kitri.board.model;

public class AlbumDto extends BoardDto {
	private int aseq;
	private String orignPicture; // 원본사진
	private String savePicture; // 실제 저장된 사진 orign과 save 둘이 다른 이유는 사진 이름이 똑같으면 안되기때문에
	private String saveFolder; // 실제 저장된 사진 경로
	private int type; // 가로 사진인지 세로사진인지

	public int getAseq() {
		return aseq;
	}

	public void setAseq(int aseq) {
		this.aseq = aseq;
	}

	public String getOrignPicture() {
		return orignPicture;
	}

	public void setOrignPicture(String orignPicture) {
		this.orignPicture = orignPicture;
	}

	public String getSavePicture() {
		return savePicture;
	}

	public void setSavePicture(String savePicture) {
		this.savePicture = savePicture;
	}

	public String getSaveFolder() {
		return saveFolder;
	}

	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
