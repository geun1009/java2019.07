<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	// ���� ����¡�� ���� begin�� end���� ���ؾ� �ϸ�
	// �׸��� ����¡ ����� �ϱ� ���� ��ü������ �� ,
	// ���� ������ ������ ���ؾ� �Ѵ�.
	int nowPage = 1;// ���� ������ ��
	int nowBlock = 1;// ���� ��
	int totalRecord = 0;// �� �Խù� ��
	int numPerPage = 10;// �� �������� ������ �Խù� ��
	int pagePerBlock = 5;// �� ���� ������ ������ ��
	int totalPage = 0;// ��ü ������ ��
	int totalBlock = 0;// ��ü �� ��
	int beginPerPage = 0;// �� �������� ���� �Խù��� index��
	int endPerPage = 0;// �� �������� ������ �Խù��� index��
%>