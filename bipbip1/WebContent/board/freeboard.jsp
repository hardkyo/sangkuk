<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<center>
<h1> 자유게시판 </h1>
</center>
<hr/>
    <div class="jumbotron">
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-8">
			<div class="btn-group">
				 
				<button class="btn btn-default" type="button">
					기본
				</button> 
				<button class="btn btn-default" type="button">
 					Hot
				</button> 
				<button class="btn btn-default" type="button">
					Best
				</button> 
			</div>
<!-- freeboard -->
			<table class="table">
<!-- board head -->
				<thead>
					<tr>
						<th width="10%">
							글번호
						</th>
						<th width="50%">
							제목
						</th>
						<th width="10%">
							글쓴이
						</th>
						<th width="14%">
							날짜
						</th>
						<th width="8%">
							조회
						</th>
						<th width="8%">
							추천
						</th>
					</tr>
				</thead>
<!-- board body -->
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr class="active">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
					</tr>
					<tr class="success">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr class="danger">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
				</tbody>
			</table>

        <!-- Pagination -->
			
        <div class="row text-center">
            <div class="col-lg-12">
                <ul class="pagination">
                    <li>
                        <a href="#">&laquo;</a>
                    </li>
                    <li class="active">
                        <a href="#">1</a>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                    <li>
                        <a href="#">4</a>
                    </li>
                    <li>
                        <a href="#">5</a>
                    </li>
                    <li>
                        <a href="#">&raquo;</a>
                    </li>
                </ul>
            </div>
        </div>
        
<!-- write button & write modal -->
		<div class="container">
			<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">
				글쓰기
			</button>
			
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
					
<!-- write modal header -->			
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">글쓰기</h4>
						</div>
<!-- write modal body -->			
						<div class="modal-body">
							<form name="writeForm" method="get" action="">
							    <div class="form-group">
							      <label for="usr">제목</label>
							      <input type="text" class="form-control" id="subject"/>
							    </div>
							    <div class="form-group">
									<label for="comment">Comment:</label>
									<textarea class="form-control" rows="15" id="content">
									</textarea>
								</div> 
							</form>
						</div>
<!-- write modal body -->						
						<div class="modal-footer">
							<button type="button" class="btn btn-default" id="writeBtn">Write</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
        
<!-- search -->
	<div class="">
		<form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<select name=sfl class="form-control">
				<option value='subject'>제목</option>
				<option value='content'>내용</option>
				<option value='subject||content'>제목+내용</option>
				<option value='mb_id,1'>회원아이디</option>
				<option value='wr_name,1'>이름</option>
				</select>
			</div>
			<div class="form-group">
				<input class="form-control" type="text" />
			</div> 
			<button class="btn btn-default" type="submit">
				검색
			</button>
		</form>
	</div>

<!-- ads -->
		<blockquote class="col-md-12">
			<p>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.
			</p> <small>Someone famous <cite>Source Title</cite></small>
		</blockquote>
		</div>
		<div class="col-md-1">
		</div>
		<div class="col-md-2">
			<div class="carousel slide" id="carousel-624603">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-624603">
					</li>
					<li data-slide-to="1" data-target="#carousel-624603">
					</li>
					<li data-slide-to="2" data-target="#carousel-624603" class="active">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item">
						<img alt="Carousel Bootstrap First" src="http://lorempixel.com/output/sports-q-c-1600-500-1.jpg">
						<div class="carousel-caption">
							<h4>
								First Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="Carousel Bootstrap Second" src="http://lorempixel.com/output/sports-q-c-1600-500-2.jpg">
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item active">
						<img alt="Carousel Bootstrap Third" src="http://lorempixel.com/output/sports-q-c-1600-500-3.jpg">
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-624603" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-624603" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	</div>
</div>

