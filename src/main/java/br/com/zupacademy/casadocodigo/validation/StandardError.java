package br.com.zupacademy.casadocodigo.validation;

public class StandardError {
	
	private Integer status;
	private String mensagem;
	private Long timeStamp;
	
	
	public StandardError(Integer status, String mensagem, Long timeStamp) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.timeStamp = timeStamp;
	}


	public Integer getStatus() {
		return status;
	}


	public String getMensagem() {
		return mensagem;
	}


	public Long getTimeStamp() {
		return timeStamp;
	}
	
	
	

}
