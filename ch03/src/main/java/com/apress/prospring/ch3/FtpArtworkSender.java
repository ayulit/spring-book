package com.apress.prospring.ch3;

public class FtpArtworkSender implements ArtworkSender {

	public void sendArtwork(String artworkPath, Recipient recipient) {
		// Work with FTP logics

	}

	public String getFriendlyName() {
		return "File Transfer Protocol";
	}

	public String getShortName() {
		return "ftp";
	}

}
