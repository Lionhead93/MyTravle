<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
	.skip {overflow: hidden; position: absolute; width: 1px; height: 1px; margin: -1px; padding: 0; border: 0; clip: rect(0 0 0 0);}
	
	.exchange_rate_wrap {width: 100%; height: 225px;}
	.exchange_rate_wrap h3 {margin: 0; padding: 0; font-size: inherit; font-weight: inherit;}
	.exchange_rate_wrap h3 .titlee {font-size: 20px; font-weight: 700;}
	.exchange_rate_wrap h3 .datee_wrap {display: block; margin-top: 10px; margin-bottom: 15px;}
	.exchange_rate_wrap .exchange_cont::after {content: ''; display: block; clear: both;}
	.exchange_rate_wrap .exchange_data_wrap {position: relative; width: 100%;}
	.exchange_rate_wrap .exchange_data_wrap .kor {background-color: #a3daff;}
	.exchange_rate_wrap .exchange_data_wrap, .exchange_rate_wrap .exchange_convert_wrap {float: left; width: 50%;}
	.exchange_rate_wrap .exchange_data_wrap > span {position: absolute; top: -35px; right: 5px; font-size: 22px;}
	.exchange_rate_wrap .exchange_data_wrap > span > span {cursor: pointer;}
	.exchange_rate_wrap .exchange_data_wrap > span > span.disabled {color: #cbcbcb; cursor: default; pointer-events: none;}
	.exchange_rate_wrap .exchange_data_wrap > div {position: relative; height: 226px; overflow: hidden;}
	.exchange_rate_wrap ul, .exchange_rate_wrap li {margin: 0; padding: 0; list-style:none;}
	.exchange_rate_wrap ul {position: absolute; top: -1; width: 100%; box-sizing: border-box;}
	.exchange_rate_wrap li
		{position: relative; height: 45px; line-height: 45px;
		border-top: 1px solid #cbcbcb; border-left: 1px solid #cbcbcb; border-right: 1px solid #cbcbcb;}
	.exchange_rate_wrap li:hover {background-color: #cbcbcb; cursor: default;}
	.exchange_rate_wrap li:last-child {border-bottom: 1px solid #cbcbcb;}
	.exchange_rate_wrap li span {display: inline-block; height: 40px;}
	.exchange_rate_wrap li .flagg
		{position: absolute; top: 2px; left: 10px; width: 45px; height: 40px;
		background-size: 100% 100%; background-repeat: no-repeat; background-position: center center;}
	.exchange_rate_wrap li .dataa {position: absolute; left: 65px;}
	.exchange_rate_wrap li .korr {font-weight: 700;}
	.exchange_rate_wrap li .unitt {color: #30a9de;}
	.exchange_rate_wrap li .exchange_ratee {position: absolute; right: 15px;}
	
	.exchange_rate_wrap .exchange_convert_wrap form {margin-left: 25px;}
	.exchange_rate_wrap .exchange_convert_wrap form > div {position: relative; width: 100%; margin-top: 50px;}
	.exchange_rate_wrap .exchange_convert_wrap select {font-size: 16px; border: 1px solid #a3daff;}
	.exchange_rate_wrap .exchange_convert_wrap select:focus {box-shadow: none; border-color: #a3daff; outline: 0;}
	.exchange_rate_wrap .exchange_convert_wrap input[type=text] {height: 37px; margin-top: 12px; text-align: right; border-radius: 0;}
	.exchange_rate_wrap .exchange_convert_wrap input[type=text]:focus {box-shadow: none; border-color: #f2c029; outline: 0;}
	.exchange_rate_wrap .exchange_convert_wrap .changee_parent {position: absolute; top: -45px; right: 0; width: 100%; height: auto; text-align: center;}
	.exchange_rate_wrap .exchange_convert_wrap .changee_parent .changee {color: #f2c029; font-size: 28px;}
	.exchange_rate_wrap .exchange_convert_wrap .changee_parent .changee svg
		{-ms-transform: rotate(90deg); -webkit-transform: rotate(90deg); transform: rotate(90deg);}
</style>

<script>
	$(function() {
		convert();
		
		// 리스트 위아래 버튼
		$(document).on('click', '.exchange_rate_wrap .exchange_data_wrap > span > span:first-child', function() {
			//console.log('현재 top : ' + $('.exchange_rate_wrap ul').css('top'));
			
			if($('.exchange_rate_wrap ul').css('top') == '-675px'){
				$(this).next().removeClass('disabled');
				$('.exchange_rate_wrap ul').animate({top:'-450px'}, 'slow');
			}else if($('.exchange_rate_wrap ul').css('top') == '-450px'){
				$('.exchange_rate_wrap ul').animate({top:'-225px'}, 'slow');
			}else if($('.exchange_rate_wrap ul').css('top') == '-225px'){
				$('.exchange_rate_wrap ul').animate({top:'0px'}, 'slow');
				$(this).addClass('disabled');
			}
		});
		$(document).on('click', '.exchange_rate_wrap .exchange_data_wrap > span > span:last-child', function() {
			//console.log('현재 top : ' + $('.exchange_rate_wrap ul').css('top'));
			
			if($('.exchange_rate_wrap ul').css('top') == '0px'){
				$(this).prev().removeClass('disabled');
				$('.exchange_rate_wrap ul').animate({top:'-225px'}, 'slow');
			}else if($('.exchange_rate_wrap ul').css('top') == '-225px'){
				$('.exchange_rate_wrap ul').animate({top:'-450px'}, 'slow');
			}else if($('.exchange_rate_wrap ul').css('top') == '-450px'){
				$('.exchange_rate_wrap ul').animate({top:'-675px'}, 'slow');
				$(this).addClass('disabled');
			}
		});
		
		// 리스트 클릭시 셀렉트로 적용
		$(document).on('click', '.exchange_rate_wrap ul li', function() {
			var fromValue = $(this).find('.unitt').text().trim();
			//console.log('선택한 화폐단위 : ' + fromValue);
			
			$('#from').val(fromValue).prop('selected', true);
			
	        if($('#amount').val() != null && $('#amount').val() != 0){
	        	convert();
	        }else{
	        	$('#exchange_result').val('0');
	        }
	    });
		
		// 환율 계산기 작동
		$(document).on('keyup', '#amount', function() {
			var regexp = /[^0-9]/gi;
	        var data = $(this).val();

	        if(regexp.test(data)){
	        	$(this).val(data.replace(regexp, ''));
	        }
	        
	        if($('#amount').val() != null && $('#amount').val() != 0){
	        	convert();
	        }else{
	        	$('#exchange_result').val('0');
	        }
	    });
		$(document).on('change', '#from, #to', function() {
			if($('#amount').val() != null && $('#amount').val() != 0){
	        	convert();
	        }else{
	        	$('#exchange_result').val('0');
	        }
	    });
		$(document).on('click', '.exchange_rate_wrap .exchange_convert_wrap .changee', function() {
			var up = $('#from').val();
			var down = $('#to').val();
			
			$('#from').val(down).prop('selected', true);
			$('#to').val(up).prop('selected', true);
			
			
			if($('#amount').val() != null && $('#amount').val() != 0){
	        	convert();
	        }else{
	        	$('#exchange_result').val('0');
	        }
	    });
	});
	
	// https://ko.exchange-rates.org 크롤링
	function exchangeRatesData() {
		$.ajax({
			url		: '/wallet/json/exchangeRates',
			method	: 'POST',
			headers	: {
				'Accept'		: 'Application/json',
				'Content-Type'	: 'Application/json'
			},
			error	: function(request, status, error) {
				//console.log('[ERROR]\nCODE :: ' + request.status + '\nMESSAGE : ' + request.responsehtml + '\nERROR : ' + error);
		    },
			success	: function(JSONData, status) {
				//console.log(status);
				//console.log('JSONData LIST 길이 :: ' + JSONData.length);
				
				$('.exchange_rate_wrap h3 span.datee').text(currentTime());
				
				$.each(JSONData, function(index, item) {
					$('.exchange_rate_wrap ul').append(
						'<li>' +
							'<span>' +
								'<span class="flagg" style="background-image: url(/resources/images/flag/' + item.unit + '.svg)"></span>' +
								'<span class="dataa">' +
									'<span>' + item.nation + '</span>&nbsp;&nbsp;-&nbsp;&nbsp;<span class="unitt">' + item.unit + '</span>' +
								'</span>' +
							'</span>' +
							'<span class="exchange_ratee">' + makeComma(item.exchangeRate) + '</span>' +
						'</li>'
					);
					
					$('.exchange_rate_wrap .exchange_convert_wrap #from, .exchange_rate_wrap .exchange_convert_wrap #to').append(
							'<option value="' + item.unit + '">' + item.nation + '</option>'
					);
					
					if(item.unit == 'EUR'){
						$('.exchange_rate_wrap .exchange_convert_wrap #from').val(item.unit).prop('selected', true);
					}
				});
				
				convert();
			}
		})
	}
	function convert(){
		$.ajax({
			url		: '/wallet/json/convert',
			method	: 'POST',
			headers	: {
				'Accept'		: 'Application/json',
				'Content-Type'	: 'Application/json'
			},
			data	: JSON.stringify({
				from	: $('#from').val(),
				to		: $('#to').val(),
				amount	: $('#amount').val()
			}),
			error	: function(request, status, error) {
				//console.log('[ERROR]\nCODE :: ' + request.status + '\nMESSAGE : ' + request.responsehtml + '\nERROR : ' + error);
		    },
			success	: function(JSONData, status) {
				//console.log('JSONData :: ' + JSONData);
				
				$('#exchange_result').val(makeComma(JSONData.exchangeRate*$('#amount').val()));
			}
		});
	}
	
	// 현재 날짜 및 시간
	function currentTime() {
		var day = new Date();
		
		return day.getFullYear() + '년 ' + (day.getMonth()+1) + '월 ' + day.getDate() + '일 ' + day.getHours() + ':' + day.getMinutes();
	}
	
	// 세자리 콤마
	function makeComma(db) {
		//console.log('콤마 적용 전 : ' + db);
		//console.log('콤마 적용 후 : ' + db.toLocaleString(undefined, {maximumFractionDigits : 2}));
		
		return db.toLocaleString(undefined, {maximumFractionDigits : 2});
	}
</script>

<section class="exchange_rate_wrap">
	<h3>
		<span class="titlee">오늘의 환율</span>
		<span class="datee_wrap"><span class="datee"></span> 기준</span>
	</h3>
	<div class="exchange_cont">
		<div class="exchange_data_wrap">
			<span><span class="disabled"><i class="fas fa-angle-up"></i></span>&nbsp;&nbsp;<span><i class="fas fa-angle-down"></i></span></span>
			<div>
				<ul>
					<li class="kor">
						<span>
							<span class="flagg" style="background-image: url(/resources/images/flag/KRW.svg)"></span>
								<span class="dataa korr">
									<span>대한민국 원</span>&nbsp;&nbsp;-&nbsp;&nbsp;<span class="unitt">KRW</span>
								</span>
							</span>
							<span class="exchange_ratee korr">1</span>
					</li>
				</ul>
			</div>
		</div>
		<div class="exchange_convert_wrap">
			<form>
				<label for="from" class="skip">변환 전 통화</label>
				<select class="form-control" name="from" id="from">
					<option value="KRW">대한민국</option>
				</select>
				<input type="text" class="form-control amountt" id="amount" name="amount" value="1" />
				
				<div>
					<label for="to" class="skip">변환 후 통화</label>
					<select class="form-control" name="to" id="to">
						<option value="KRW" selected>대한민국</option>
					</select>
					<input type="text" class="form-control" id="exchange_result" readonly />
					
					<span class="changee_parent"><a class="changee"><span class="skip">위치 바꾸기</span> <i class="fas fa-exchange-alt"></i></a></span>
				</div>
			</form>
		</div><!-- //exchange_convert_wrap -->
	</div><!-- //exchange_cont -->
</section><!-- //exchange_rate_wrap -->