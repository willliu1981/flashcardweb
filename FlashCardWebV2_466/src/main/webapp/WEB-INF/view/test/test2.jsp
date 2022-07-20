<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">

.nezuko {
  --s: #b7afa4;
  --b: #121013;

  height: min(450px,98vh,75vw);
  aspect-ratio: 1.3;
  margin: auto auto 0;
  position: relative;
  overflow: hidden;
  z-index: 0;
}
.nezuko:before {
  content: "";
  position: absolute;
  inset: 56% 26% 0% 26%;
  background: #0a0b0f;
  z-index: -1;
}
.nezuko:after {
  content: "";
  position: absolute;
  width: 15%;
  height: 1.5%;
  background: linear-gradient(#807681 70%,#0000);
  top: 83%;
  left: 43%;
  mix-blend-mode: darken;
  clip-path: polygon(1% 0,100% 0,100% 100%,0 100%);
}
.face {
  position: absolute;
  inset: 22% 30% 12% 30.5%;
  background: 
    radial-gradient(97% 100% at 100% 100%,#0000 99%,#7f757e) 0 0/58% 47%,
    radial-gradient(100% 100% at 100% 100%,#0000 99%,#7f757e) 0 0/76% 42%,
    radial-gradient(100% 100% at 0 100%,#0000 98%,#7f757e) 100% 0%/48% 44%,
    linear-gradient(var(--s) 0 0) top/100% 46%;
  background-repeat: no-repeat;
  filter: 
    drop-shadow(0 0 1px #20101b) 
    drop-shadow(0 0 0px #20101b)
    drop-shadow(0 0 0px #20101b);
}
@supports (-moz-appearance:none) {
  .face { 
    filter: 
      drop-shadow(0 0 1px #20101b) 
      drop-shadow(0 0 1px #20101b)
      drop-shadow(0 0 0px #20101b);  
  } 
}
.face:before {
  content: "";
  position: absolute;
  inset: 26% 0 0 50%;
  background: 
    conic-gradient(from -33deg at 50% 100%,#0000,var(--b) 2deg 22deg,#0000 27deg) 63% 51%/12% 13%,
    conic-gradient(from -40deg at 50% 100%,#0000,var(--b) 2deg 22deg,#0000 27deg) 71% 51.5%/12% 13%,
    conic-gradient(from -40deg at 50% 100%,#0000,var(--b) 2deg 22deg,#0000 27deg) 77% 51%/12% 13%,
    var(--s);
  background-repeat: no-repeat;
  border-bottom-right-radius: 100% 64%;
  transform-origin: bottom left;
  transform: skewY(-9deg);
  clip-path: polygon(0 0,100% 18%,100% 100%,0 100%);
}
.face:after {
  content: "";
  position: absolute;
  inset: 26% 49.5% 0 -6%;
  background: 
    conic-gradient(from 6deg at 50% 100%,#0000,var(--b) 2deg 22deg,#0000 27deg) 48% 54%/12% 13%,
    conic-gradient(from 10deg at 50% 100%,#0000,var(--b) 2deg 22deg,#0000 27deg) 42% 54.5%/12% 13%,
    conic-gradient(from 10deg at 50% 100%,#0000,var(--b) 2deg 22deg,#0000 27deg) 36% 54.5%/12% 13%,
    linear-gradient(98deg,#7f757e 65%,#0000 72%) 10% 42%/5% 19%,    
    var(--s);
  background-repeat: no-repeat;
  border-bottom-left-radius: 100% 90%;
  transform-origin: bottom right;
  transform: skewY(13deg);
  clip-path: polygon(0% 39%,100% 25%,100% 100%,0 100%);
}
.eye-r {
  position: absolute;
  z-index: 2;
  right: 8.5%;
  top: 43%;
  height: 21%;
  width: 25%;
  background: 
    radial-gradient(97% 95% at 45% 0%, #0000 99%, var(--b) 101%),
    radial-gradient(68% 81% at 50% 100%, #0000 98%, #6d747c) #b7bbba;
  border-radius: 50%;
  clip-path: polygon(-100% -100%, 200% -100%, 100% 100%, -6% 94%);
}
.eye-r:before {
  content: "";
  position: absolute;
  inset: 13% 15% 13% 13%;
  background: 
    radial-gradient(50% 50%, #e0ebe7 65%, #0000) 30% 28%/26% 26% no-repeat,
    radial-gradient(50% 50%, #632e64 84%, #0000) 49% 49%/38% 36% no-repeat,
    radial-gradient(50% 50%, #a0728e 72%, #e0ccd9);
  filter: 
    drop-shadow(0 0 1px #80757d) 
    drop-shadow(0 0 0px #80757d)
    drop-shadow(0 0 0px #80757d);
  border-radius: 50%;
}
.eye-r:after {
  content: "";
  position: absolute;
  inset: -3% -14% 0 -8%;
  background: radial-gradient(65% 89% at 50% 100%, #0000 98%, var(--b));
  border-radius: 50%;
}
.eye-l {
  position: absolute;
  left: 11%;
  top: 43%;
  z-index: 2;
  height: 21%;
  width: 25%;
  background: 
    radial-gradient(97% 95% at 55% 0%, #0000 99%, var(--b) 101%),    
    radial-gradient(68% 81% at 50% 100%, #0000 98%, #6d747c), 
    #b7bbba;
  border-radius: 50%;
  clip-path: polygon(-100% -100%, 200% -100%, 106% 94%, 0 100%);
}
.eye-l:before {
  content: "";
  position: absolute;
  inset: 13% 12% 13% 18%;
  background: 
    radial-gradient(50% 50%, #e0ebe7 65%, #0000) 34% 31%/26% 26% no-repeat,
    radial-gradient(50% 50%, #632e64 84%, #0000) 54% 48%/38% 36% no-repeat,
    radial-gradient(50% 50%, #a0728e 72%, #e0ccd9);
  filter: 
    drop-shadow(0 0 1px #80757d) 
    drop-shadow(0 0 0px #80757d)
    drop-shadow(0 0 0px #80757d);
  border-radius: 50%;
}
.eye-l:after {
  content: "";
  position: absolute;
  inset: -2% -11% 0 -14%;
  background: radial-gradient(65% 89% at 50% 100%, #0000 98%, var(--b));
  border-radius: 50%;
}
.u-eye:before {
  content: "";
  position: absolute;
  right: 2%;
  top: 33.5%;
  width: 35%;
  height: 7%;
  background: radial-gradient(79% 91% at 73% 100%, #0000 96%, var(--b));
  border-radius: 78% 40% 0 0/83% 28% 0 0;
  z-index: 9;
}
.u-eye:after {
  content: "";
  position: absolute;
  left: 5%;
  top: 34%;
  width: 37%;
  height: 7%;
  background: radial-gradient(79% 91% at 28% 100%, #0000 96%, var(--b));
  border-radius: 45% 70% 0 0/20% 83% 0 0;
  z-index: 9;
}
.nose {
  position: absolute;
  width: 6%;
  height: 7.5%;
  background: 
    linear-gradient(#5c5157 0 0) 31% 51%/1px 21% no-repeat,
    linear-gradient(#5c5157 0 0) 14% 47%/1px 33% no-repeat, 
    #898086;
  top: 62%;
  left: 54%;
  border-radius: 30% 70% 74% 26% / 30% 61% 39% 70%;
  clip-path: polygon(-200% 0, 52% 0, 100% 50%, 100% 200%, -200% 200%);
  z-index: 9;
}
.nose:before {
  content: "";
  position: absolute;
  width: 69%;
  height: 24%;
  top: 117%;
  right: 15%;
  border-top: 1px solid #6d655a;
  border-radius: 50%;
  filter: drop-shadow(0 0 0px #6d655a);
  transform: rotate(-32deg);
  clip-path: inset(-105% 4%);
}
.nose:after {
  content: "";
  position: absolute;
  width: 69%;
  height: 24%;
  top: 119%;
  left: -128%;
  border-top: 1px solid #6d655a;
  border-radius: 50%;
  filter: drop-shadow(0 0 0px #6d655a);
  transform: rotate(32deg);
  clip-path: inset(-105% 4%);
}
.mouth {
  position: absolute;
  inset: 77% 4% 7.5% 6%;
  background: 
    linear-gradient(90deg,#0c1e20,#0000 5% 89%,#0c1e20)50% 84%/90% 4%,
    linear-gradient(90deg,#1b3220,#0000 6% )50% 48%/90% 4%,
    linear-gradient(90deg,#1b3220,#0000 8% 95%,#1b3220)50% 41%/90% 4%,
    linear-gradient(90deg,#1b3220,#0000 20% 60%,#1b3220)50% 51%/48% 4%,
    linear-gradient(90deg,#1b3220,#0000 40% 80%,#1b3220)50% 44%/48% 4%,
    linear-gradient(#889b88 0 0) 0 12%/100% 14%,  
    linear-gradient(#374939, #506c56 30% 56%, #203d3b 62%);
  background-repeat: no-repeat;
  border-radius: 2%/42%;
  clip-path: circle(69%);
  z-index: 10;
  filter: drop-shadow(0 0 0px #0a0b0f);
}
.mouth:before {
  content: "";
  position: absolute;
  top: -7%;
  bottom: -7%;
  width: 4%;
  left: 25%;
  background: 
    radial-gradient(50% 50% at 37% 50%, #889b88 93%, #0000) 0% 10%/100% 13% no-repeat,
    linear-gradient(#506c56 56%, #203d3b 62%);
  border-radius: 999px;
  filter: drop-shadow(0 0 1px #20101b) drop-shadow(0 0 0px #20101b);
}
.mouth:after {
  content: "";
  position: absolute;
  top: -7%;
  bottom: -7%;
  width: 4%;
  right: 25%;
  background: 
    radial-gradient(88% 50% at 32% 50%, #889b88 83%, #0000) 0% 10%/84% 13% no-repeat,
    linear-gradient(#506c56 56%, #203d3b 62%);
  border-radius: 999px;
  filter: drop-shadow(0 0 1px #20101b) drop-shadow(0 0 0px #20101b);
}
.mouth > div:before {
  content: "";
  position: absolute;
  top: -7%;
  bottom: -7%;
  width: 5%;
  left: 0;
  background: 
    linear-gradient(22deg, #0000 29%, #889b88 32% 75%, #0000 80%) 0% 10%/100% 16% no-repeat,
    linear-gradient(#506c56 56%, #203d3b 62%);
  filter: drop-shadow(0 0 1px #20101b) drop-shadow(0 0 0px #20101b);
  clip-path: polygon(0% -6%, 130% 10%, 130% 90%, 0% 112%);
}
.mouth > div:after {
  content: "";
  position: absolute;
  top: -7%;
  bottom: -7%;
  width: 5%;
  right: 0;
  background: 
    linear-gradient(-22deg, #0000 29%, #889b88 32% 75%, #0000 80%) 0% 10%/100% 16% no-repeat,
    linear-gradient(#506c56 56%, #203d3b 62%);
  filter: 
    drop-shadow(0 0 1px #20101b) 
    drop-shadow(0 0 0px #20101b);
  clip-path: polygon(-30% 10%, 100% -6%, 100% 106%, -30% 92%);
}
@supports (-moz-appearance:none) {
  .mouth { 
    filter: 
      drop-shadow(0 0 1px #0a0b0f) 
      drop-shadow(0 0 0px #0a0b0f) 
      drop-shadow(0 0 0px #0a0b0f);  
  } 
}
.neck {
  position: absolute;
  inset: 81% 39% -2% 41%;
  background: #7f7580;
  background: #807681;
  border: 1px solid var(--b);
}
.neck:before {
  content: "";
  position: absolute;
  bottom: 0;
  left: 8%;
  width: 37%;
  height: 103%;
  background: 
    linear-gradient(to top right, #0000 50%, var(--b) 53%) 100% 128%/53% 89% no-repeat,
    #83818e;
  transform-origin: bottom right;
  transform: rotate(-25deg);
  border-top-left-radius: 60% 32%;
  border: inherit;
  clip-path: polygon(0 0, 65% 0, 50% 13%, 100% 100%, 0 100%);
  box-sizing: border-box;
  z-index: 2;
}
.neck:after {
  content: "";
  position: absolute;
  bottom: 0;
  right: 8%;
  width: 37%;
  height: 103%;
  background: 
    linear-gradient(to top left, #0000 50%, var(--b) 53%) 0 128%/48% 90% no-repeat,
    #83818e;
  transform-origin: bottom left;
  transform: rotate(25deg);
  border-top-right-radius: 60% 32%;
  border: inherit;
  clip-path: polygon(45% 14%, 30% 0, 100% 0, 100% 100%, 0 100%);
  box-sizing: border-box;
  z-index: 2;
}
.u-neck:before {
  content: "";
  position: absolute;
  width: 16%;
  height: 13%;
  left: 26%;
  bottom: 0;
  background:
    linear-gradient(to top right,#0000 48%,#472e4b 49% 50%,#0000 51%),
    linear-gradient(#472e4b 0 0) 50% 30%/100% 3% no-repeat,
    #654665;
  clip-path: polygon(0% 127%, 79% 0, 91% 0, 100% 100%, 0 100%);
  z-index: 1;
}
.u-neck:after {
  content: "";
  position: absolute;
  width: 16%;
  height: 13%;
  right: 24%;
  bottom: 0;
  background: 
    linear-gradient(to top right,#0000 48%,#472e4b 49% 50%,#0000 51%) 37%/37% 100% no-repeat,
    linear-gradient(to top right,#0000 47%,#472e4b 49% 50%,#0000 52%) 24%/24% 100% no-repeat,
    #654665;
  clip-path: polygon(8% 0, 21% 0, 100% 127%, 100% 100%, 0 100%);
  z-index: 1;
}
.hair {
  --h: #df4b143b;
  --h: /*#27343c*/ #1b242b;
  --ha: #0a0b0f;
  position: absolute;
  inset: 0;
  background: 
    linear-gradient(var(--ha) 0 0) 28% 88%/3% 10%,
    linear-gradient(var(--ha) 0 0) 27% 100%/4% 13%,
    linear-gradient(94deg, #0000 61%, var(--ha) 63% 86%,#0000 88%) 24% 75%/9% 22%,
    linear-gradient(to bottom right, #0000 59%, var(--ha) 61%) 25% 88%/3% 15%,
    radial-gradient(99% 82% at 110% 72%, var(--ha) 95%, #0000) 24% 100%/3% 12%,
    radial-gradient(35% 54% at 0 50%, var(--ha) 90%, #0000) 24% 66%/3% 20%,
    linear-gradient(105deg, var(--ha) 46%, #0000 48%) 21% 80%/7% 10%,
    linear-gradient(to bottom right, #0000 48%, var(--ha) 50%) 20.5% 65%/4% 20%,
    radial-gradient(237% 235% at -100% -100%, #0000 99%, var(--ha)) 12% 85%/8% 18%,
    radial-gradient(75% 76% at 100% 48%, #0000 98%, var(--ha)) 20% 100%/8% 18%,
    linear-gradient(to bottom right, #0000 49%, var(--ha) 50%) 17% 81%/5% 18%,
    linear-gradient(to bottom right, #0000 49%, var(--ha) 50%) 5% 100%/16% 22%,
    linear-gradient(96deg, #0000 55%, var(--ha) 56%) 77% 76%/4% 20%,
    radial-gradient(81% 58% at 100% 72%, var(--ha) 97%, #0000) 77% 100%/4% 30%,
    radial-gradient(169% 112% at 170% 0%, #0000 99%, var(--ha)) 96% 100%/19% 40%,
    radial-gradient(48% 52% at 100% 50%, var(--ha) 96%, #0000) 69% 100%/3% 29%,
    radial-gradient(66% 113% at 100% 0%, #0000 98%, var(--ha)) 73.1% 100%/5% 25%,
    radial-gradient(106% 108% at 0% 100%, var(--ha) 97%, #0000) 70% 30%/2% 8%,
    radial-gradient(59% 56% at 0 50%, var(--ha) 95%, #0000) 72% 61%/3% 45%,
    linear-gradient(91deg, #0000 23%, var(--ha) 24% 55%, #0000 0) 72% 72%/5% 23%,
    linear-gradient(85deg, #0000 26%, var(--ha) 29% 55%, #0000 0) 71% 42%/4% 23%,
    /**/ 
    radial-gradient(100% 100%at 100% 0, var(--h) 95%, #0000) 23% 54%/4% 7%,
    linear-gradient(var(--h) 0 0) 22% 100%/7% 24%,
    linear-gradient(var(--h) 0 0) 76% 100%/6% 38%,
    linear-gradient(to top right, #0000 49%, var(--h) 50%) 67% 24%/13% 11%,
    linear-gradient(to top left, #0000 49%, var(--h) 50%) 33% 26%/10% 14%,
    linear-gradient(var(--h) 0 0) 26% 46%/6% 9%,
    radial-gradient(237% 235% at -100% -100%, #0000 99%, var(--h)) 11% 81%/8% 16%,
    linear-gradient(133deg, #0000 49%, var(--h) 50% 60%, #0000 62%) 0% 100%/20% 26%,
    linear-gradient(106deg, #0000 50%, var(--h) 51%) 14% 68%/17% 26%,
    radial-gradient(102% 129% at 100% 86%, var(--h) 97%, #0000) 23% 45%/3% 10%,
    radial-gradient(112% 123% at 109% 113%, var(--h) 98%, #0000) 25% 28%/8% 23%,
    radial-gradient(122% 143% at 129% -28%, #0000 99%, var(--h)) 110% 100%/30% 38%,
    radial-gradient(100% 164% at -15% 112%, var(--h) 98%, #0000) 76% 24%/9% 9%,
    linear-gradient(82deg, var(--h) 49%, #0000 50%) 84% 45%/16% 32%,
    radial-gradient(50% 106% at 50% 119%, var(--h) 99%, #0000) 52% 3%/48% 20%;
  background-repeat: no-repeat;
  z-index: 10;
  clip-path: polygon(
    0 0,
    100% 0,
    100% 100%,
    94.5% 100%,
    88.3% 95.7%,
    89.5% 100%,
    12% 100%,
    14% 93%,
    7.5% 100%,
    0 100%
  );
  filter: 
    drop-shadow(0px 0px 1px var(--ha)) 
    drop-shadow(0px 0px 0px var(--ha))
    drop-shadow(0px 0px 0px var(--ha));
}
@supports (-moz-appearance:none) {
  .hair { 
    filter: 
      drop-shadow(0px 0px 1px var(--ha)) 
      drop-shadow(0px 0px 1px var(--ha)) 
      drop-shadow(0px 0px 1px var(--ha)) 
      drop-shadow(0px 0px 0px var(--ha));  
  } 
}
.hair:before {
  content: "";
  position: absolute;
  inset: 20.5% 30% 67% 33.5%;
  background: 
    conic-gradient( from -87deg, #0000,var(--ha) 2deg 138deg, #0000 142deg) 10% 61%/20% 31% no-repeat,
    radial-gradient(50% 81%at 46% 114%, #0000 98%, var(--ha));
  border-radius: 67% 100% 0 0/150% 119% 0 0;
  clip-path: polygon(
    0 0,
    100% 0,
    100% 100%,
    33% 100%,
    57% 29%,
    36% 35%,
    39% 25%,
    27% 43%,
    30% 28%,
    22% 47%,
    21% 100%,
    0 100%
  );
}
.hair:after {
  content: "";
  position: absolute;
  width: 9%;
  height: 32%;
  background: radial-gradient(73% 81.5% at 100% 81%, #0000 98%, var(--ha));
  left: 28%;
  top: 28.8%;
  border-radius: 87% 0 0 0;
}
.h1:before {
  content: "";
  position: absolute;
  background: var(--ha);
  width: 1px;
  height: 8%;
  left: 23.5%;
  top: 46%;
  transform: rotate(-3deg);
}
.h1:after {
  content: "";
  position: absolute;
  background: var(--ha);
  width: 1px;
  height: 6%;
  left: 22.8%;
  top: 47%;
  transform: rotate(13deg);
}
.h2:before {
  content: "";
  position: absolute;
  width: 17%;
  height: 31%;
  background: radial-gradient(100% 112% at 102% 104%, #0000 99%, var(--ha));
  top: 17%;
  left: 23.2%;
  border-radius: 71% 0 0 0/100% 0 0 0;
}
.h2:after {
  content: "";
  position: absolute;
  width: 26%;
  height: 13%;
  background: radial-gradient(57% 89% at 58% 100%, #0000 98%, var(--ha));
  border-radius: 50%;
  left: 39%;
  top: 16%;
}
.h3 {
  position: absolute;
  width: 32.5%;
  height: 13%;
  background: radial-gradient(50% 111% at 50% 112%, #0000 98%, var(--ha));
  top: 7.5%;
  left: 36.4%;
  border-radius: 49% 62% 0 0/110% 100% 0 0;
}
.h3:before {
  content: "";
  position: absolute;
  left: 0;
  top: 20%;
  width: 13%;
  height: 126%;
  background: radial-gradient(72% 44% at 100% 43%, #0000 98%, var(--ha));
  border-radius: 100% 0 0 24%/45% 0 0 53%;
}
.h3:after {
  content: "";
  position: absolute;
  right: -4%;
  top: 46%;
  height: 58%;
  width: 6%;
  background: linear-gradient(90deg, #0000 30%, var(--ha) 0);
  border-radius: 0 100% 0 0;
}
.h4:before {
  content: "";
  position: absolute;
  right: 22%;
  bottom: 39%;
  width: 9%;
  height: 39%;
  background: radial-gradient(90% 97% at 0% 106%, #0000 99%, var(--ha));
  border-radius: 0 100% 0 0;
}
.h4:after {
  content: "";
  position: absolute;
  left: 33.5%;
  top: 15.5%;
  width: 5%;
  height: 2%;
  background: linear-gradient(var(--ha) 55%, #0000 0);
  border-radius: 50% 50% 0 0/100% 100% 0 0;
  transform: rotate(38deg);
}
.ear-r {
  position: absolute;
  background: #807681;
  height: 13%;
  width: 7%;
  border-radius: 50%;
  right: 29%;
  bottom: 27.5%;
  transform: rotate(23deg);
}
.ear-r:before {
  content: "";
  position: absolute;
  inset: 6% 22% 24% 0;
  border: 1px solid #3c3135;
  border-radius: 50%;
}
.ear-l {
  position: absolute;
  background: #807681;
  height: 16%;
  width: 10%;
  border-radius: 50%;
  left: 30%;
  bottom: 26.5%;
  transform: rotate(-60deg);
}
.ear-l:before {
  content: "";
  position: absolute;
  inset: 13% 25% 47% 22%;
  border: 1px solid #3c3135;
  border-radius: 50% 0 0 50%;
  transform: rotate(94deg);
}
.eye-r-u:before {
  content: "";
  position: absolute;
  height: 8%;
  width: 4%;
  background: radial-gradient(68% 60% at 0% 31%,#0000 92%,var(--b));
  right: 5%;
  top: 41%;
  border-radius: 0 39% 100% 0/0 40% 50% 0;
  transform: rotate(65deg);
}
.eye-r-u:after {
  content: "";
  position: absolute;
  width: 34.5%;
  height: 17%;
  top: 43.5%;
  right: 3%;
  border-top: 2px solid var(--b);
  border-radius: 50%;
  clip-path: inset(0 3% 0 5%);
}
.eye-l-u:before {
  content: "";
  position: absolute;
  height: 8%;
  width: 4%;
  background: radial-gradient(68% 60% at 100% 31%,#0000 92%,var(--b));
  left: 6%;
  top: 41%;
  border-radius: 39% 0 0 100%/40% 0 0 50%;
  transform: rotate(-65deg);
  z-index: 9;
}
.eye-l-u:after {
  content: "";
  position: absolute;
  width: 37%;
  height: 23%;
  top: 43%;
  left: 5%;
  border-top: 2px solid var(--b);
  border-radius: 50%;
  z-index: 9;
  clip-path: inset(0 9% 0 3%);
}
.ribbon {
  position: absolute;
  inset: 0;
  z-index: 99;
  filter: 
    drop-shadow(0px 0px 1px #0a0b0f)     
    drop-shadow(0px 0px 0px #0a0b0f);
}
@supports (-moz-appearance:none) {
  .ribbon { 
    filter: 
      drop-shadow(0 0 1px #0a0b0f) 
      drop-shadow(0 0 1px #0a0b0f);  
  } 
}
.ribbon:after {
  content: "";
  position: absolute;
  width: 3.5%;
  height: 8%;
  background: linear-gradient(45deg,#7d6a81 48%,#b09ea6 57%);
  right: 29%;
  top: 20%;
  border-radius: 0 0 24% 59%/0 0 24% 29%;
  -webkit-mask-image: radial-gradient(39% 78% at 0 0,#0000 95%,#000);
  clip-path: polygon(0 -15%,100% 26%,100% 100%,0 100%);
  box-sizing: border-box;
  border: 1px solid #0a0b0f;
}
.ribbon:before {
  content: "";
  position: absolute;
  width: 3%;
  height: 4%;
  background: #b0a2ac;
  right: 28%;
  top: 23%;
  transform: rotate(45deg);
  border-radius: 35%;
  border: 1px solid #0a0b0f;
  box-sizing: border-box;
}
.ribbon div:before {
  content: "";
  position: absolute;
  right: 18%;
  top: 22%;
  width: 11%;
  height: 9%;
  background:
    linear-gradient(to top right,#0000 46%,#472e4b 47% 52%,#0000 53%) -25% 54%/46% 30% no-repeat,
    radial-gradient( at 100% 50%, #b29da3 44%,#7d6a7e 45%) 100%/100% 200%;
  border-radius: 0 0 100% 100%/0 0 71% 87%;
  -webkit-mask: 
    linear-gradient(to bottom right,#0000 52%,#000 53%)100%/120% 100%,
    radial-gradient(69% 55% at 34% -12%,#0000 98%,#000);
  z-index: -2;
  clip-path: polygon(0 0,100% 0,100% 100%,37% 100%,0 58%);
}
.ribbon div:after {
  content: "";
  position: absolute;
  right: 19%;
  top: 14%;
  width: 12%;
  height: 9%;
  background: 
    linear-gradient(to top right,#0000 46%,#472e4b 47% 52%,#0000 53%) -9% 67%/43% 30% no-repeat,
    linear-gradient(-83deg, #b29da3 53%,#7d6a7e 55%) 100%/100% 98% no-repeat;
  border-radius: 0 0 100% 100%/0 0 71% 87%;
  -webkit-mask: 
    linear-gradient(to bottom right,#0000 54%,#000 55%)100%/157% 100%,
    radial-gradient(67% 55% at 46% -12%,#0000 98%,#000);
  z-index: -2;
  clip-path: polygon(0 0,100% 0,100% 100%,37% 100%,0 58%);
  transform: rotate(-49deg);
}
.eye-r-u div:before {
  content: "";
  position: absolute;
  right: 15%;
  top: 39%;
  width: 26%;
  height: 11%;
  background: 
    linear-gradient(to top left,#0000 49%,#898086 50%) 0 0/59% 109% no-repeat,
    radial-gradient(81% 110% at 84% 121%,#0000 98%,#898086);
  border-radius: 71% 33% 0 0/91% 33% 0 0;
  clip-path: polygon(22% 0,100% 0,100% 100%,2% 100%);
}
.eye-r-u div:after {
  content: "";
  position: absolute;
  width: 33%;
  height: 16%;
  right: 5%;
  top: 40%;
  border-radius: 50%;
  border-top: 1px solid #3c303a;
  clip-path: inset(0 8% 0 9%);
  -webkit-mask: linear-gradient(90deg,#000 66%,#0000 68% 73%,#000 82%);
}
.eye-l-u div:before {
  content: "";
  position: absolute;
  left: 17%;
  top: 39%;
  width: 26%;
  height: 10%;
  background: 
    linear-gradient(to top right,#0000 49%,#898086 50%) 100% 0/59% 98% no-repeat,
    radial-gradient(112% 108% at -5% 120%,#0000 98%,#898086);
  z-index: 9;
  border-radius: 29% 75% 0 0/20% 100% 0 0;
  clip-path: polygon(0 10%,57% 2%,100% 0,100% 100%,0 100%);
}
.eye-l-u div:after {
  content: "";
  position: absolute;
  width: 35%;
  height: 17%;
  left: 6%;
  top: 40%;
  border-radius: 50%;
  border-top: 1px solid #3c303a;
  clip-path: inset(0 6% 0 13%);
  -webkit-mask: linear-gradient(-90deg,#000 65%,#0000 68% 73%,#000 82%);
  z-index: 10;
}
body {
  margin: 0;
  min-height: 100vh;
  display: grid;
  background-color: #b7d0d5;
  background-color: #1a2e30;
}


</style>

</head>
<body>


    <div class="nezuko">
        <div class="u-neck"></div>
        <div class="neck"></div>
        <div class="ear-r"></div>
        <div class="ear-l"></div>
        <div class="face">
            <div class="u-eye"></div>
            <div class="eye-r"></div>
            <div class="eye-r-u">
                <div></div>
            </div>
            <div class="eye-l"></div>
            <div class="eye-l-u">
                <div></div>
            </div>
            <div class="nose"></div>
            <div class="mouth">
                <div></div>
            </div>
        </div>
        <div class="hair">
            <div class="h1"></div>
            <div class="h2"></div>
            <div class="h3"></div>
            <div class="h4"></div>
        </div>
        <div class="ribbon">
            <div></div>
        </div>
    </div>

</body>
</html>