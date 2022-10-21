<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
<style>
body,ul,li{
    list-style:none;
    padding:0;
    margin:0;
}
a{
    text-decoration:none;
    color:inherit;
}
/*노말라이즈 끝*/

/*좌측사이드바*/
.left-side-bar{
    background-color:#dfdfdf;
    width:300px;
    height:100%;
    left:-270px;
    top:0;
    position:fixed;
    transition:left .3s;
}
.left-side-bar:hover{
    left:0;
}

/*좌측사이드바-아이콘*/
.left-side-bar > .icon-status > span{
    text-align:right;
    display:block;
}
.left-side-bar > .icon-status > span:last-child{
    display:none;
}
.left-side-bar:hover > .icon-status > span:last-child{
    display:block;
}
.left-side-bar:hover > .icon-status > span:first-child{
    display:none;
}
/*좌측사이드바-아이콘 끝*/

/*좌측사이드바-메뉴박스*/
.left-side-bar > .menu-box-1 > ul ul{
    display:none;
    position:absolute;
    left:100%;
    top:0;
}
.left-side-bar > .menu-box-1 ul{
    background-color:#dfdfdf;
}
.left-side-bar > .menu-box-1 ul > li{
    position:relative;
}
.left-side-bar > .menu-box-1 ul > li > a{
    display:block;
    padding:10px;
    white-space:nowrap;
}
.left-side-bar .menu-box-1 ul > li:hover > a{
    background-color:black;
    color:white;
}
.left-side-bar > .menu-box-1 > ul > li:hover > ul{
    display:block;
}
</style>
</style>
</head>
<div class="left-side-bar">
    <!--좌측사이드바-아이콘-->
    <div class="icon-status">
        <span>▶</span>
        <span>▼</span>
    </div>
    <!--좌측사이드바-아이콘 끝-->
    <!--좌측사이드바-메뉴박스-->
    <nav class="menu-box-1">
    <label>${adminInfo.admin_id }</label>
        <ul>
            <li>
                <a href="#">회원관리</a>
                <ul>
                    <li>
                        <a href="adminMember.do">회원조회</a>                   
                    </li>
                    <li>
                        <a href="adminMemberRegister.do">관리자등록</a>
                    </li>
                    <li>
                        <a href="adminSearch.do">관리자조회</a>                        
                    </li>
                    <li>
                        <a href="adminDetail.do">상세조회</a>                        
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">매출관리</a>
                <ul>
                    <li>
                        <a href="#">2차메뉴아이템 1</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">2차메뉴아이템 2</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">2차메뉴아이템 3</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">2차메뉴아이템 4</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">1차메뉴아이템 3</a>
                <ul>
                    <li>
                        <a href="#">2차메뉴아이템 1</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">2차메뉴아이템 2</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">2차메뉴아이템 3</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">2차메뉴아이템 4</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">1차메뉴아이템 4</a>
                <ul>
                    <li>
                        <a href="#">2차메뉴아이템 1</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">2차메뉴아이템 2</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">2차메뉴아이템 3</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">2차메뉴아이템 4</a>
                        <ul>
                            <li><a href="#">3차메뉴아이템 1</a></li>
                            <li><a href="#">3차메뉴아이템 2</a></li>
                            <li><a href="#">3차메뉴아이템 3</a></li>
                            <li><a href="#">3차메뉴아이템 4</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
    <!--좌측사이드바-메뉴박스-->
</div>
<!--좌측사이드바 끝-->
</html>