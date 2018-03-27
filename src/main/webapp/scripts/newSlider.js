jQuery(document).ready(function($) {	

var slideIndex= 1;

$(function() {
	showSlides(slideIndex);
	
});

$('a.Next').click(function() {
	plusSlides(1);
});
$('a.Prev').click(function() {
	plusSlides(-1);
});
$('span.dot#one').click(function() {
	currentSlide(1);
});
$('span.dot#two').click(function() {
	currentSlide(2);
});
$('span.dot#three').click(function() {
	currentSlide(3);
});
$('span.dot#four').click(function() {
	currentSlide(4);
})

    function plusSlides(x) {
	showSlides(slideIndex+= x);
}
    function currentSlide(x) {
	showSlides(slideIndex= x);
}

function showSlides(x) {
	var a;
	var x;
	var slides= document.getElementsByClassName("slides"); //mySlides
	var dots= document.getElementsByClassName("dot");
	if (x> slides.length) {slideIndex= 1}
	if (x< 1) {slideIndex= slides.length}
	
	for (a= 0; a < slides.length; a++) {
		slides[a].style.display= "none";
	}
	for (a= 0; a < dots.length; a++) {
		dots[a].className= dots[a].className.replace(" active", "");
	}
	slides[slideIndex- 1].style.display= "block";
	dots[slideIndex- 1].className+= " active";
}
});