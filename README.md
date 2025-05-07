# [2025.04] 내일의집 웹 프로젝트 제작
통계청의 장래인구 및 가구추계 자료에 의하면 <b>1인 가구 비율은 앞으로
약 12% 증가할 것으로 전망</b>되고 있습니다. <br>이와 같은 증가추세는 가구 및 인테리어 제품의 구매 비율 또한 증가를 예상하여 가구, 인테리어 쇼핑몰 프로젝트를 진행하게 되었습니다.<br>
또한, 커뮤니티 게시판을 추가하여 구매자가 <b>커뮤니티에서 다른 사람들의 구매 후기, 배치사진 등을 보면서 제품에 대한 신뢰가 쌓이고 바로 쇼핑으로 이어질 가능성을 높이기 위함</b> 입니다.<br>

통계청 출처: <https://kostat.go.kr/board.es?mid=a10301020600&bid=207>

## 0. 목차
1. [프로젝트 개요](#1-프로젝트-개요)
2. [프로젝트 사용 기술](#2-프로젝트-사용-기술)
3. [주요 기능](#3-주요-기능)
<br> ▶ [본인인증 방식](#본인인증-방식--카카오네이버구글-api-smtp이메일-인증)
<br> ▶ [커뮤니티 글 작성](#커뮤니티-게시글-작성--draganddrop-api-summernote)
<br> ▶ [커뮤니티 댓글](#커뮤니티-댓글-작성--ajax)
<br> ▶ [주문페이지-배송지선택](#주문-페이지--기본-배송지--배송지-입력daum-주소검색-api)
<br> ▶ [장바구니](#장바구니)
<br> ▶ [리뷰작성/목록](#리뷰작성--상품-상세-페이지-리뷰)
4. [역할](#4-역할)

## 1. 프로젝트 개요

- 프로젝트명 : 내일의집(naeilhome)

- 개발 기간 : 2025.02.18 ~ 2025.04.25 (9주차)
  - 1주차 : 주제선정, 요구사항 명세서 작성
  - 2주차 : 데이터베이스 설계, 화면 설계
  - 3주차 ~ 6주차 : 기능구현
  - 6주차 ~ 8주차 : 화면 UI 디자인, 오류 테스트
  - 8주차 ~ 9주차 : 발표 준비 및 이력서 작성

- 개발 인원 : 5명

- 배포 주소 : <http://www.naeilhome.p-e.kr/>

## 2. 프로젝트 사용 기술
- <b>Backend</b> : <img src="https://img.shields.io/badge/SpringBoot-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" /> <img src="https://img.shields.io/badge/MyBatis-F80000?style=for-the-badge&logo=oracle&logoColor=white" /> <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" />

- <b>Frontend</b> : <img src="https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white" /> <img src="https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white" /> <img src="https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white" /> <img src="https://img.shields.io/badge/AJAX-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white" /> <img src="https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E" /> <img src="https://img.shields.io/badge/JSTL-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E" /> <img src="https://img.shields.io/badge/Tiles-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E" />

- <b>RDBMS</b> : <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white" />
 
- <b>DevOps</b> : <img src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white" /> <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)" />
 
- <b>Infra</b> : <img src="https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black" /> <img src="https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white" /> <img src="https://img.shields.io/badge/Ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white" />


## 3. 주요 기능
### 본인인증 방식 : 카카오/네이버/구글 API, SMTP(이메일) 인증
<img src="/image/login1.jpg" width="100%" />
<img src="/image/login3.png" />

---
### 커뮤니티 게시글 작성 : DragAndDrop API, SummerNote
<img src="/image/write_board1.png" width="100%"/>

---
### 커뮤니티 댓글 작성 : AJAX
<img src="/image/reply1.png" width="100%"/>

---
### 주문 페이지 : 기본 배송지 / 배송지 입력(Daum 주소검색 API)
<img src="/image/pay1.png" width="100%"/>

---
### 장바구니
<img src="/image/basket.png" width="100%"/>

---
### 리뷰작성 / 상품 상세 페이지 리뷰
<img src="/image/write_review1.png" width="100%"/>

## 4. 역할
- **데이터베이스 설계 및 총괄** - PK, FK, Sequence, Trigger 등등 Oracle DB 담당
- **카카오 로그인/회원가입 API, Daum 주소검색 API 구현**
- **회원가입 구현** - 기입란에 맞지 않는 입력 감지필터, 아이디/닉네임 중복확인(Ajax), 주소 입력란 Daum 주소검색 API 이용
- **상품 목록 및 카테고리 구현** - 상품목록 페이징 및 카테고리 선택 시 localStorage를 이용하여 카테고리 글씨 색상 변경 유지
- **장바구니 구현** - 전체선택/개별선택, 실시간 구매금액 출력
- **주문 배송지 선택 구현** - 회원가입 시 입력한 주소지 / Daum 주소검색 API로 배송지 입력
- **주문 배송 목록 페이지 구현** - 결제 완료 시 구매취소, 배송 완료 시 구매확정과 반품/교환신청, 구매확정 시 리뷰작성
- **취소/반품/교환 신청 페이지 구현** - 반품/교환 시 다중 파일 업로드, 미리보기, 개별삭제, 전체삭제

