!function(){var e="@charset \"utf-8\";html{color:#000;background:#fff;overflow-y:scroll;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%}html *{outline:0;-webkit-text-size-adjust:none;-webkit-tap-highlight-color:rgba(0,0,0,0)}html,body{font-family:sans-serif}body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,code,form,fieldset,legend,input,textarea,p,blockquote,th,td,hr,button,article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section{margin:0;padding:0}input,select,textarea{font-size:100%}table{border-collapse:collapse;border-spacing:0}fieldset,img{border:0}abbr,acronym{border:0;font-variant:normal}del{text-decoration:line-through}address,caption,cite,code,dfn,em,th,var{font-style:normal;font-weight:500}ol,ul{list-style:none}caption,th{text-align:left}h1,h2,h3,h4,h5,h6{font-size:100%;font-weight:500}q:before,q:after{content:''}sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}sup{top:-.5em}sub{bottom:-.25em}a:hover{text-decoration:underline}ins,a{text-decoration:none}",t=document.createElement("style");if(document.getElementsByTagName("head")[0].appendChild(t),t.styleSheet)t.styleSheet.disabled||(t.styleSheet.cssText=e);else try{t.innerHTML=e}catch(i){t.innerText=e}}(),function(e,t){var i,n=e.document,a=n.documentElement,r=n.querySelector('meta[name="viewport"]'),o=n.querySelector('meta[name="flexible.52c69250"]'),l=0,s=0,d=t.flexible||(t.flexible={});if(r){console.warn("将根据已有的meta标签来设置缩放比例");var c=r.getAttribute("content").match(/initial\-scale=([\d\.]+)/);c&&(s=parseFloat(c[1]),l=parseInt(1/s))}else if(o){var m=o.getAttribute("content");if(m){var h=m.match(/initial\-dpr=([\d\.]+)/),p=m.match(/maximum\-dpr=([\d\.]+)/);h&&(l=parseFloat(h[1]),s=parseFloat((1/l).toFixed(2))),p&&(l=parseFloat(p[1]),s=parseFloat((1/l).toFixed(2)))}}if(!l&&!s){e.navigator.appVersion.match(/android/gi);var f=e.navigator.appVersion.match(/iphone/gi),u=e.devicePixelRatio;s=1/(l=f?u>=3&&(!l||l>=3)?3:u>=2&&(!l||l>=2)?2:1:1)}if(a.setAttribute("data-dpr",l),!r)if((r=n.createElement("meta")).setAttribute("name","viewport"),r.setAttribute("content","initial-scale="+s+", maximum-scale="+s+", minimum-scale="+s+", user-scalable=no"),a.firstElementChild)a.firstElementChild.appendChild(r);else{var b=n.createElement("div");b.appendChild(r),n.write(b.innerHTML)}function g(){var t=a.getBoundingClientRect().width;t/l>540&&(t=540*l);var i=t/10;a.style.fontSize=i+"px",d.rem=e.rem=i}e.addEventListener("resize",function(){clearTimeout(i),i=setTimeout(g,300)},!1),e.addEventListener("pageshow",function(e){e.persisted&&(clearTimeout(i),i=setTimeout(g,300))},!1),"complete"===n.readyState?n.body.style.fontSize=12*l+"px":n.addEventListener("DOMContentLoaded",function(e){n.body.style.fontSize=12*l+"px"},!1),g(),d.dpr=e.dpr=l,d.refreshRem=g,d.rem2px=function(e){var t=parseFloat(e)*this.rem;return"string"==typeof e&&e.match(/rem$/)&&(t+="px"),t},d.px2rem=function(e){var t=parseFloat(e)/this.rem;return"string"==typeof e&&e.match(/px$/)&&(t+="rem"),t}}(window,window.lib||(window.lib={}));