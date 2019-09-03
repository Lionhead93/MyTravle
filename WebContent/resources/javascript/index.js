$(function(){
//	
	setInterval(getTime, 1000);
	
	function getTime() {
		$.ajax({
			url : "/guide/json/getTime",
			method : "POST" ,
			//dataType : "json" ,
			headers : {
				"Accept" : "application/json",
				"Content-Type" : "application/json"
			},
			success : function(JSONData , status) {
				$.each(JSONData , function(index,item){
					if(item.countryName == '한국') {
						$('.time_data.seoul .times').text(item.time);
					}else if(item.countryName == '서유럽'){
						$('.time_data.london .times').text(item.time);
					}else if(item.countryName == '중앙유럽'){
						$('.time_data.paris .times').text(item.time);
					}else if(item.countryName == '러시아'){
						$('.time_data.mockba .times').text(item.time);
					}else if(item.countryName == '미국'){
						$('.time_data.newyork .times').text(item.time);
					}else if(item.countryName == '호주'){
						$('.time_data.sydney .times').text(item.time);
					}else if(item.countryName == '브라질'){
						$('.time_data.paulo .times').text(item.time);
					}
					//console.log(item.countryName);
					//console.log(item.time);
					//console.log(item.timeGap);
				})
			}
			,
			error:function( jqXHR, textStatus, errorThrown){
				/*alert(textStatus);
				alert(errorThrown);*/
			}
		}) // end ajax 
	}
	
//	$('body').oLoader({
//		  wholeWindow: true, //makes the loader fit the window size
//		  lockOverflow: true, //disable scrollbar on body
//		   
//		  backgroundColor: '#282c37',
//		  fadeInTime: 1000,
//		  fadeLevel: 0.7,
//		  image: '../resources/images/ownageLoader/430377_e43058e053634b499f67c63cd1e3ba02_mv2.gif',  
//		 
//		});
	
	$('.nodeTest').on('click',function(){
		console.log("현재접속 호출 전");
		currentUser('1');
		console.log("현재접속 호출 후");
	})
	
	// 날씨 init
	getWeather("37.499427","127.029422");
	// 37.499427, 127.029422
	$('#callCountry').on('click',function(){
				selectCity();
	});
	
	$(document).on('click','.wCity',function(){
		$('#weatherCity').val($(this).text().trim());
		$.ajax({
			url : '/guide/json/getCity',
			method : 'post',
			data : JSON.stringify ({
				cityName : $(this).text().trim()
			}),
			headers : {
				"Accpet":"application/json",
				"Content-Type" : "application/json"
			},
			success : function(data,status){
				//alert(data[0].lat);
				//alert(data[0].lng);
				getWeather(data[0].lat,data[0].lng)
			}
		})
	});
	
	
	function getWeather(lat,lng) {
		
		$.ajax({
			url : '/guide/json/getWeather',
			method : 'post',
			data : JSON.stringify ({
				lat : lat,
				lng : lng
			}),
			headers : {
				"Accpet":"application/json",
				"Content-Type" : "application/json"
			},
			success : function(data,status){
				//alert(data);
				
//				$('.weatherImg').attr('src','http://openweathermap.org/img/wn/'+data.icon+'@2x.png');
				$('.weatherImg').attr('src','/resources/images/weather/'+data.icon+'.png').attr('alt','/resources/images/weather/04d.png');
				$('.mainTemp').text(data.temp);
				//$('.mainMinMaxTemp').text(data.tempMin+'/'+data.tempMax);
				$('.mainMinMaxTemp span:first-child').text(data.tempMin);
				$('.mainMinMaxTemp span:last-child').text(data.tempMax);
				
				$('.humidity').text(data.humidity);
				$('.weatherCity').text($('#weatherCountry').val() +' - ' + $('#weatherCity').val() );
				$(".popup_wrap").css('display','none');
				
			}
		})
	}

		
		
	$(document).on('click','.weatherCountry',function(){
		$('#weatherCountry').val($(this).text().trim());
		$.each($('.wCity'),function(){
			//alert("안들어오나?")
			$(this).remove();
			$(this).css('display','none');
			$(this).empty();
		})
		
		if($(this).hasClass('active') === true) {
			//alert("액티브있음")
			$.each($('button[class*=weatherCountry]'),function(){
				$(this).removeClass('active');
				$(this).css('display','block');
			});
			return;
		}else {
			//alert("액티브없음")
			$.each($('button[class*=weatherCountry]'),function(){
				$(this).removeClass('active');
				$(this).css('display','none');
				
			});
			$(this).addClass('active');
			$(this).css('display','block');
		}
		
		
		
		
		
		
		var countryName = $(this).text().trim();
		
		$.ajax({
			url : '/guide/json/getCity',
			method : 'post',
			data : JSON.stringify ({
				countryName : countryName
			}),
			headers : {
				"Accpet":"application/json",
				"Content-Type" : "application/json"
			},
			success : function(data,status){
				
				$.each(data,function(index,item){
					
					$('button[class^='+item.countryCode).after(
					'<button type="button" class="wCity list-group-item list-group-item-action">'
					+'<small>'+item.cityName+'</small>'
					+'</button>'
					);
				})
			}
		});
	})
	
	$('.weatherCountry').on('click',function(){
		
	})
	
	
});

//$(window).load(function(){
//	$('body').oLoader('hide');
//});;

$(function() {
	
	// 환율 정보 .jsp 온로드
	$($('#exchange_container')).load('exchangeRates.jsp', function(data) {
		//console.log(data);
		
		exchangeRatesData();
	});
	
	
});