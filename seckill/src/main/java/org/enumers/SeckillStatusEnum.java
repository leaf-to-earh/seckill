package org.enumers;

/*
 * ʹ��ö�ٱ������������ֵ䣬����ɱ״̬
 */
public enum SeckillStatusEnum {
	SUCCESS(1, "��ɱ�ɹ�"),
	END(0, "��ɱ����"),
	REPEAT_KILL(-1, "�ظ���ɱ"),
	INNER_ERROR(-2, "ϵͳ�쳣"),
	DATA_REWRITE(-3, "���ݴ۸�");
	private int status;
	
	private String statusInfo;

	private SeckillStatusEnum(int status, String statusInfo) {
		this.status = status;
		this.statusInfo = statusInfo;
	}

	public int getStatus() {
		return status;
	}

	public String getStatusInfo() {
		return statusInfo;
	}
	
	public static SeckillStatusEnum statusOf(int index){
		for(SeckillStatusEnum status :values()){
			if(status.getStatus() ==  index){
				return status;
			}
		}
		return null;
	}
}
