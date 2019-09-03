
		$(function(){
			
			
		
		// 수입/지출 추가 모달창 닫기 버튼
		$('.popup_wrap').on('click', function(e) {
			var container = $('.popup_wrap');
			console.log(container.has(e.target).length);
			if(container.has(e.target).length === 0){
				$(".popup_wrap").css('display','none');
			}
		});
		
		// 프로필 정보 닫기
		$('.profilePop_wrap').on('click', function(e) {
			var container = $('.profilePop_wrap');
			//console.log(container.has(e.target).length);
			if(container.has(e.target).length === 0){
				$(".profilePop_wrap").css('display','none');
				$(".profilePopup").css('display','none');
				$('.profilePopup').empty();
			}
		});
		
		
		$(document).on('click','.profilePop_wrap',function(e) {
			//console.log("바디로 들어옴");
			
			var container = $('.profilePop_wrap');
			//console.log(container.has(e.target).length);
			if(container.has(e.target).length === 0){
				$(".profilePop_wrap").css('display','none');
				$(".profilePopup").css('display','none');
				$('.profilePopup').empty();
			}
			//console.log("종료");
		})
		
		
		$('.fCity').on('click',function(){
			var way =$('#way').val();
			if(way == 'startWay') {
				$('#startWay').val($(this).text().trim());
				$('#startCode').val($(this).val().trim());
			}else {
				$('#endWay').val($(this).text().trim());
				$('#endCode').val($(this).val().trim());
			}
			$(".popup_wrap").css('display','none');
			
			})
		
		$('.flightCountry').on('click',function(){
			$.each($('.flightCountry'),function(){
				$(this).removeClass('active');
			});
			$.each($('.flightCity'),function(){
				$(this).css('display','none');
			})
			$(this).addClass('active');
			if($(this).text().trim() == '대한민국'){
				$(this).after($('div[class*=seoul').css('display','block'));
			}
			if($(this).text().trim() == '네덜란드'){
				$(this).after($('div[class*=spejf').css('display','block'));
			}
			if($(this).text().trim() == '독일'){
				$(this).after($('div[class*=ehrdlf').css('display','block'));
			}
			if($(this).text().trim() == '벨기에'){
				$(this).after($('div[class*=qpfrl').css('display','block'));
			}
			if($(this).text().trim() == '스위스'){
				$(this).after($('div[class*=tmdnl').css('display','block'));
			}
			if($(this).text().trim() == '스페인'){
				$(this).after($('div[class*=tmvp').css('display','block'));
			}
			if($(this).text().trim() == '영국'){
				$(this).after($('div[class*=dudrnr').css('display','block'));
			}
			if($(this).text().trim() == '오스트리아'){
				$(this).after($('div[class*=dhtm').css('display','block'));
			}
			if($(this).text().trim() == '이탈리아'){
				$(this).after($('div[class*=dlxkf').css('display','block'));
			}
			if($(this).text().trim() == '체코'){
				$(this).after($('div[class*=cpzh').css('display','block'));
			}
			if($(this).text().trim() == '프랑스'){
				$(this).after($('div[class*=vmfkd').css('display','block'));
			}
			if($(this).text().trim() == '헝가리'){
				$(this).after($('div[class*=gjdrk').css('display','block'));
			}
		})
		
		
		
	})
	

	
function selectCity() {
			
			$(".popup_wrap").css('display','block');
			centerPopUp($(".popup_contain"), $(".popup_contain").width(), $(".popup_contain").height() );
		}	
	
	
	// 팝업 중앙에 띄우기
function centerPopUp(modal, modalWidth, modalHeight) {
	console.log('모달창 넓이 : ' + modalWidth + 'px, 높이 : ' + modalHeight + 'px');

	var left = Math.ceil((window.screen.width - modalWidth) / 2);
	var top = Math.ceil(((window.screen.height - modalHeight) / 2) - 50);
	
	modal.css({'display':'block'});
	modal.css({'top':top, 'left':left});
}

		