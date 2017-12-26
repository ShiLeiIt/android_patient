function stringReturnNull(t){return t||"暂无"}!function(t,e){"function"==typeof define&&define.amd?define(function(){return e(t)}):e(t)}(this,function(t){var e=function(){function e(t){return null==t?String(t):W[q.call(t)]||"object"}function n(t){return"function"==e(t)}function i(t){return null!=t&&t==t.window}function o(t){return null!=t&&t.nodeType==t.DOCUMENT_NODE}function r(t){return"object"==e(t)}function s(t){return r(t)&&!i(t)&&Object.getPrototypeOf(t)==Object.prototype}function a(t){var e=!!t&&"length"in t&&t.length,n=x.type(t);return"function"!=n&&!i(t)&&("array"==n||0===e||"number"==typeof e&&e>0&&e-1 in t)}function c(t){return t.replace(/::/g,"/").replace(/([A-Z]+)([A-Z][a-z])/g,"$1_$2").replace(/([a-z\d])([A-Z])/g,"$1_$2").replace(/_/g,"-").toLowerCase()}function u(t){return t in O?O[t]:O[t]=new RegExp("(^|\\s)"+t+"(\\s|$)")}function l(t,e){return"number"!=typeof e||$[c(t)]?e:e+"px"}function h(t){return"children"in t?N.call(t.children):x.map(t.childNodes,function(t){return 1==t.nodeType?t:void 0})}function f(t,e){var n,i=t?t.length:0;for(n=0;i>n;n++)this[n]=t[n];this.length=i,this.selector=e||""}function d(t,e,n){for(b in e)n&&(s(e[b])||J(e[b]))?(s(e[b])&&!s(t[b])&&(t[b]={}),J(e[b])&&!J(t[b])&&(t[b]=[]),d(t[b],e[b],n)):e[b]!==w&&(t[b]=e[b])}function p(t,e){return null==e?x(t):x(t).filter(e)}function m(t,e,i,o){return n(e)?e.call(t,i,o):e}function v(t,e,n){null==n?t.removeAttribute(e):t.setAttribute(e,n)}function g(t,e){var n=t.className||"",i=n&&n.baseVal!==w;return e===w?i?n.baseVal:n:void(i?n.baseVal=e:t.className=e)}function y(t){try{return t?"true"==t||"false"!=t&&("null"==t?null:+t+""==t?+t:/^[\[\{]/.test(t)?x.parseJSON(t):t):t}catch(e){return t}}function E(t,e){e(t);for(var n=0,i=t.childNodes.length;i>n;n++)E(t.childNodes[n],e)}var w,b,x,T,C,k,S=[],D=S.concat,L=S.filter,N=S.slice,j=t.document,A={},O={},$={"column-count":1,columns:1,"font-weight":1,"line-height":1,opacity:1,"z-index":1,zoom:1},P=/^\s*<(\w+|!)[^>]*>/,M=/^<(\w+)\s*\/?>(?:<\/\1>|)$/,_=/<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi,F=/^(?:body|html)$/i,U=/([A-Z])/g,R=["val","css","html","text","data","width","height","offset"],H=j.createElement("table"),I=j.createElement("tr"),Y={tr:j.createElement("tbody"),tbody:H,thead:H,tfoot:H,td:I,th:I,"*":j.createElement("div")},B=/complete|loaded|interactive/,z=/^[\w-]*$/,W={},q=W.toString,X={},Z=j.createElement("div"),V={tabindex:"tabIndex",readonly:"readOnly",for:"htmlFor",class:"className",maxlength:"maxLength",cellspacing:"cellSpacing",cellpadding:"cellPadding",rowspan:"rowSpan",colspan:"colSpan",usemap:"useMap",frameborder:"frameBorder",contenteditable:"contentEditable"},J=Array.isArray||function(t){return t instanceof Array};return X.matches=function(t,e){if(!e||!t||1!==t.nodeType)return!1;var n=t.matches||t.webkitMatchesSelector||t.mozMatchesSelector||t.oMatchesSelector||t.matchesSelector;if(n)return n.call(t,e);var i,o=t.parentNode,r=!o;return r&&(o=Z).appendChild(t),i=~X.qsa(o,e).indexOf(t),r&&Z.removeChild(t),i},C=function(t){return t.replace(/-+(.)?/g,function(t,e){return e?e.toUpperCase():""})},k=function(t){return L.call(t,function(e,n){return t.indexOf(e)==n})},X.fragment=function(t,e,n){var i,o,r;return M.test(t)&&(i=x(j.createElement(RegExp.$1))),i||(t.replace&&(t=t.replace(_,"<$1></$2>")),e===w&&(e=P.test(t)&&RegExp.$1),e in Y||(e="*"),r=Y[e],r.innerHTML=""+t,i=x.each(N.call(r.childNodes),function(){r.removeChild(this)})),s(n)&&(o=x(i),x.each(n,function(t,e){R.indexOf(t)>-1?o[t](e):o.attr(t,e)})),i},X.Z=function(t,e){return new f(t,e)},X.isZ=function(t){return t instanceof X.Z},X.init=function(t,e){var i;if(!t)return X.Z();if("string"==typeof t)if("<"==(t=t.trim())[0]&&P.test(t))i=X.fragment(t,RegExp.$1,e),t=null;else{if(e!==w)return x(e).find(t);i=X.qsa(j,t)}else{if(n(t))return x(j).ready(t);if(X.isZ(t))return t;if(J(t))i=function(t){return L.call(t,function(t){return null!=t})}(t);else if(r(t))i=[t],t=null;else if(P.test(t))i=X.fragment(t.trim(),RegExp.$1,e),t=null;else{if(e!==w)return x(e).find(t);i=X.qsa(j,t)}}return X.Z(i,t)},x=function(t,e){return X.init(t,e)},x.extend=function(t){var e,n=N.call(arguments,1);return"boolean"==typeof t&&(e=t,t=n.shift()),n.forEach(function(n){d(t,n,e)}),t},X.qsa=function(t,e){var n,i="#"==e[0],o=!i&&"."==e[0],r=i||o?e.slice(1):e,s=z.test(r);return t.getElementById&&s&&i?(n=t.getElementById(r))?[n]:[]:1!==t.nodeType&&9!==t.nodeType&&11!==t.nodeType?[]:N.call(s&&!i&&t.getElementsByClassName?o?t.getElementsByClassName(r):t.getElementsByTagName(e):t.querySelectorAll(e))},x.contains=j.documentElement.contains?function(t,e){return t!==e&&t.contains(e)}:function(t,e){for(;e&&(e=e.parentNode);)if(e===t)return!0;return!1},x.type=e,x.isFunction=n,x.isWindow=i,x.isArray=J,x.isPlainObject=s,x.isEmptyObject=function(t){var e;for(e in t)return!1;return!0},x.isNumeric=function(t){var e=Number(t),n=typeof t;return null!=t&&"boolean"!=n&&("string"!=n||t.length)&&!isNaN(e)&&isFinite(e)||!1},x.inArray=function(t,e,n){return S.indexOf.call(e,t,n)},x.camelCase=C,x.trim=function(t){return null==t?"":String.prototype.trim.call(t)},x.uuid=0,x.support={},x.expr={},x.noop=function(){},x.map=function(t,e){var n,i,o,r=[];if(a(t))for(i=0;i<t.length;i++)null!=(n=e(t[i],i))&&r.push(n);else for(o in t)null!=(n=e(t[o],o))&&r.push(n);return function(t){return t.length>0?x.fn.concat.apply([],t):t}(r)},x.each=function(t,e){var n,i;if(a(t)){for(n=0;n<t.length;n++)if(!1===e.call(t[n],n,t[n]))return t}else for(i in t)if(!1===e.call(t[i],i,t[i]))return t;return t},x.grep=function(t,e){return L.call(t,e)},t.JSON&&(x.parseJSON=JSON.parse),x.each("Boolean Number String Function Array Date RegExp Object Error".split(" "),function(t,e){W["[object "+e+"]"]=e.toLowerCase()}),x.fn={constructor:X.Z,length:0,forEach:S.forEach,reduce:S.reduce,push:S.push,sort:S.sort,splice:S.splice,indexOf:S.indexOf,concat:function(){var t,e,n=[];for(t=0;t<arguments.length;t++)e=arguments[t],n[t]=X.isZ(e)?e.toArray():e;return D.apply(X.isZ(this)?this.toArray():this,n)},map:function(t){return x(x.map(this,function(e,n){return t.call(e,n,e)}))},slice:function(){return x(N.apply(this,arguments))},ready:function(t){return B.test(j.readyState)&&j.body?t(x):j.addEventListener("DOMContentLoaded",function(){t(x)},!1),this},get:function(t){return t===w?N.call(this):this[t>=0?t:t+this.length]},toArray:function(){return this.get()},size:function(){return this.length},remove:function(){return this.each(function(){null!=this.parentNode&&this.parentNode.removeChild(this)})},each:function(t){return S.every.call(this,function(e,n){return!1!==t.call(e,n,e)}),this},filter:function(t){return n(t)?this.not(this.not(t)):x(L.call(this,function(e){return X.matches(e,t)}))},add:function(t,e){return x(k(this.concat(x(t,e))))},is:function(t){return this.length>0&&X.matches(this[0],t)},not:function(t){var e=[];if(n(t)&&t.call!==w)this.each(function(n){t.call(this,n)||e.push(this)});else{var i="string"==typeof t?this.filter(t):a(t)&&n(t.item)?N.call(t):x(t);this.forEach(function(t){i.indexOf(t)<0&&e.push(t)})}return x(e)},has:function(t){return this.filter(function(){return r(t)?x.contains(this,t):x(this).find(t).size()})},eq:function(t){return-1===t?this.slice(t):this.slice(t,+t+1)},first:function(){var t=this[0];return t&&!r(t)?t:x(t)},last:function(){var t=this[this.length-1];return t&&!r(t)?t:x(t)},find:function(t){var e=this;return t?"object"==typeof t?x(t).filter(function(){var t=this;return S.some.call(e,function(e){return x.contains(e,t)})}):1==this.length?x(X.qsa(this[0],t)):this.map(function(){return X.qsa(this,t)}):x()},closest:function(t,e){var n=[],i="object"==typeof t&&x(t);return this.each(function(r,s){for(;s&&!(i?i.indexOf(s)>=0:X.matches(s,t));)s=s!==e&&!o(s)&&s.parentNode;s&&n.indexOf(s)<0&&n.push(s)}),x(n)},parents:function(t){for(var e=[],n=this;n.length>0;)n=x.map(n,function(t){return(t=t.parentNode)&&!o(t)&&e.indexOf(t)<0?(e.push(t),t):void 0});return p(e,t)},parent:function(t){return p(k(this.pluck("parentNode")),t)},children:function(t){return p(this.map(function(){return h(this)}),t)},contents:function(){return this.map(function(){return this.contentDocument||N.call(this.childNodes)})},siblings:function(t){return p(this.map(function(t,e){return L.call(h(e.parentNode),function(t){return t!==e})}),t)},empty:function(){return this.each(function(){this.innerHTML=""})},pluck:function(t){return x.map(this,function(e){return e[t]})},show:function(){return this.each(function(){"none"==this.style.display&&(this.style.display=""),"none"==getComputedStyle(this,"").getPropertyValue("display")&&(this.style.display=function(t){var e,n;return A[t]||(e=j.createElement(t),j.body.appendChild(e),n=getComputedStyle(e,"").getPropertyValue("display"),e.parentNode.removeChild(e),"none"==n&&(n="block"),A[t]=n),A[t]}(this.nodeName))})},replaceWith:function(t){return this.before(t).remove()},wrap:function(t){var e=n(t);if(this[0]&&!e)var i=x(t).get(0),o=i.parentNode||this.length>1;return this.each(function(n){x(this).wrapAll(e?t.call(this,n):o?i.cloneNode(!0):i)})},wrapAll:function(t){if(this[0]){x(this[0]).before(t=x(t));for(var e;(e=t.children()).length;)t=e.first();x(t).append(this)}return this},wrapInner:function(t){var e=n(t);return this.each(function(n){var i=x(this),o=i.contents(),r=e?t.call(this,n):t;o.length?o.wrapAll(r):i.append(r)})},unwrap:function(){return this.parent().each(function(){x(this).replaceWith(x(this).children())}),this},clone:function(){return this.map(function(){return this.cloneNode(!0)})},hide:function(){return this.css("display","none")},toggle:function(t){return this.each(function(){var e=x(this);(t===w?"none"==e.css("display"):t)?e.show():e.hide()})},prev:function(t){return x(this.pluck("previousElementSibling")).filter(t||"*")},next:function(t){return x(this.pluck("nextElementSibling")).filter(t||"*")},html:function(t){return 0 in arguments?this.each(function(e){var n=this.innerHTML;x(this).empty().append(m(this,t,e,n))}):0 in this?this[0].innerHTML:null},text:function(t){return 0 in arguments?this.each(function(e){var n=m(this,t,e,this.textContent);this.textContent=null==n?"":""+n}):0 in this?this.pluck("textContent").join(""):null},attr:function(t,e){var n;return"string"!=typeof t||1 in arguments?this.each(function(n){if(1===this.nodeType)if(r(t))for(b in t)v(this,b,t[b]);else v(this,t,m(this,e,n,this.getAttribute(t)))}):0 in this&&1==this[0].nodeType&&null!=(n=this[0].getAttribute(t))?n:w},removeAttr:function(t){return this.each(function(){1===this.nodeType&&t.split(" ").forEach(function(t){v(this,t)},this)})},prop:function(t,e){return t=V[t]||t,1 in arguments?this.each(function(n){this[t]=m(this,e,n,this[t])}):this[0]&&this[0][t]},removeProp:function(t){return t=V[t]||t,this.each(function(){delete this[t]})},data:function(t,e){var n="data-"+t.replace(U,"-$1").toLowerCase(),i=1 in arguments?this.attr(n,e):this.attr(n);return null!==i?y(i):w},val:function(t){return 0 in arguments?(null==t&&(t=""),this.each(function(e){this.value=m(this,t,e,this.value)})):this[0]&&(this[0].multiple?x(this[0]).find("option").filter(function(){return this.selected}).pluck("value"):this[0].value)},offset:function(e){if(e)return this.each(function(t){var n=x(this),i=m(this,e,t,n.offset()),o=n.offsetParent().offset(),r={top:i.top-o.top,left:i.left-o.left};"static"==n.css("position")&&(r.position="relative"),n.css(r)});if(!this.length)return null;if(j.documentElement!==this[0]&&!x.contains(j.documentElement,this[0]))return{top:0,left:0};var n=this[0].getBoundingClientRect();return{left:n.left+t.pageXOffset,top:n.top+t.pageYOffset,width:Math.round(n.width),height:Math.round(n.height)}},css:function(t,n){if(arguments.length<2){var i=this[0];if("string"==typeof t){if(!i)return;return i.style[C(t)]||getComputedStyle(i,"").getPropertyValue(t)}if(J(t)){if(!i)return;var o={},r=getComputedStyle(i,"");return x.each(t,function(t,e){o[e]=i.style[C(e)]||r.getPropertyValue(e)}),o}}var s="";if("string"==e(t))n||0===n?s=c(t)+":"+l(t,n):this.each(function(){this.style.removeProperty(c(t))});else for(b in t)t[b]||0===t[b]?s+=c(b)+":"+l(b,t[b])+";":this.each(function(){this.style.removeProperty(c(b))});return this.each(function(){this.style.cssText+=";"+s})},index:function(t){return t?this.indexOf(x(t)[0]):this.parent().children().indexOf(this[0])},hasClass:function(t){return!!t&&S.some.call(this,function(t){return this.test(g(t))},u(t))},addClass:function(t){return t?this.each(function(e){if("className"in this){T=[];var n=g(this);m(this,t,e,n).split(/\s+/g).forEach(function(t){x(this).hasClass(t)||T.push(t)},this),T.length&&g(this,n+(n?" ":"")+T.join(" "))}}):this},removeClass:function(t){return this.each(function(e){if("className"in this){if(t===w)return g(this,"");T=g(this),m(this,t,e,T).split(/\s+/g).forEach(function(t){T=T.replace(u(t)," ")}),g(this,T.trim())}})},toggleClass:function(t,e){return t?this.each(function(n){var i=x(this);m(this,t,n,g(this)).split(/\s+/g).forEach(function(t){(e===w?!i.hasClass(t):e)?i.addClass(t):i.removeClass(t)})}):this},scrollTop:function(t){if(this.length){var e="scrollTop"in this[0];return t===w?e?this[0].scrollTop:this[0].pageYOffset:this.each(e?function(){this.scrollTop=t}:function(){this.scrollTo(this.scrollX,t)})}},scrollLeft:function(t){if(this.length){var e="scrollLeft"in this[0];return t===w?e?this[0].scrollLeft:this[0].pageXOffset:this.each(e?function(){this.scrollLeft=t}:function(){this.scrollTo(t,this.scrollY)})}},position:function(){if(this.length){var t=this[0],e=this.offsetParent(),n=this.offset(),i=F.test(e[0].nodeName)?{top:0,left:0}:e.offset();return n.top-=parseFloat(x(t).css("margin-top"))||0,n.left-=parseFloat(x(t).css("margin-left"))||0,i.top+=parseFloat(x(e[0]).css("border-top-width"))||0,i.left+=parseFloat(x(e[0]).css("border-left-width"))||0,{top:n.top-i.top,left:n.left-i.left}}},offsetParent:function(){return this.map(function(){for(var t=this.offsetParent||j.body;t&&!F.test(t.nodeName)&&"static"==x(t).css("position");)t=t.offsetParent;return t})}},x.fn.detach=x.fn.remove,["width","height"].forEach(function(t){var e=t.replace(/./,function(t){return t[0].toUpperCase()});x.fn[t]=function(n){var r,s=this[0];return n===w?i(s)?s["inner"+e]:o(s)?s.documentElement["scroll"+e]:(r=this.offset())&&r[t]:this.each(function(e){(s=x(this)).css(t,m(this,n,e,s[t]()))})}}),["after","prepend","before","append"].forEach(function(n,i){var o=i%2;x.fn[n]=function(){var n,r,s=x.map(arguments,function(t){var i=[];return"array"==(n=e(t))?(t.forEach(function(t){return t.nodeType!==w?i.push(t):x.zepto.isZ(t)?i=i.concat(t.get()):void(i=i.concat(X.fragment(t)))}),i):"object"==n||null==t?t:X.fragment(t)}),a=this.length>1;return s.length<1?this:this.each(function(e,n){r=o?n:n.parentNode,n=0==i?n.nextSibling:1==i?n.firstChild:2==i?n:null;var c=x.contains(j.documentElement,r);s.forEach(function(e){if(a)e=e.cloneNode(!0);else if(!r)return x(e).remove();r.insertBefore(e,n),c&&E(e,function(e){if(!(null==e.nodeName||"SCRIPT"!==e.nodeName.toUpperCase()||e.type&&"text/javascript"!==e.type||e.src)){var n=e.ownerDocument?e.ownerDocument.defaultView:t;n.eval.call(n,e.innerHTML)}})})})},x.fn[o?n+"To":"insert"+(i?"Before":"After")]=function(t){return x(t)[n](this),this}}),X.Z.prototype=f.prototype=x.fn,X.uniq=k,X.deserializeValue=y,x.zepto=X,x}();return t.Zepto=e,void 0===t.$&&(t.$=e),function(e){function n(t){return t._zid||(t._zid=f++)}function i(t,e,i,r){if((e=o(e)).ns)var s=function(t){return new RegExp("(?:^| )"+t.replace(" "," .* ?")+"(?: |$)")}(e.ns);return(v[n(t)]||[]).filter(function(t){return t&&(!e.e||t.e==e.e)&&(!e.ns||s.test(t.ns))&&(!i||n(t.fn)===n(i))&&(!r||t.sel==r)})}function o(t){var e=(""+t).split(".");return{e:e[0],ns:e.slice(1).sort().join(" ")}}function r(t,e){return t.del&&!y&&t.e in E||!!e}function s(t){return w[t]||y&&E[t]||t}function a(t,i,a,c,l,f,d){var p=n(t),m=v[p]||(v[p]=[]);i.split(/\s/).forEach(function(n){if("ready"==n)return e(document).ready(a);var i=o(n);i.fn=a,i.sel=l,i.e in w&&(a=function(t){var n=t.relatedTarget;return!n||n!==this&&!e.contains(this,n)?i.fn.apply(this,arguments):void 0}),i.del=f;var p=f||a;i.proxy=function(e){if(!(e=u(e)).isImmediatePropagationStopped()){e.data=c;var n=p.apply(t,e._args==h?[e]:[e].concat(e._args));return!1===n&&(e.preventDefault(),e.stopPropagation()),n}},i.i=m.length,m.push(i),"addEventListener"in t&&t.addEventListener(s(i.e),i.proxy,r(i,d))})}function c(t,e,o,a,c){var u=n(t);(e||"").split(/\s/).forEach(function(e){i(t,e,o,a).forEach(function(e){delete v[u][e.i],"removeEventListener"in t&&t.removeEventListener(s(e.e),e.proxy,r(e,c))})})}function u(t,n){return(n||!t.isDefaultPrevented)&&(n||(n=t),e.each(C,function(e,i){var o=n[e];t[e]=function(){return this[i]=b,o&&o.apply(n,arguments)},t[i]=x}),t.timeStamp||(t.timeStamp=Date.now()),(n.defaultPrevented!==h?n.defaultPrevented:"returnValue"in n?!1===n.returnValue:n.getPreventDefault&&n.getPreventDefault())&&(t.isDefaultPrevented=b)),t}function l(t){var e,n={originalEvent:t};for(e in t)T.test(e)||t[e]===h||(n[e]=t[e]);return u(n,t)}var h,f=1,d=Array.prototype.slice,p=e.isFunction,m=function(t){return"string"==typeof t},v={},g={},y="onfocusin"in t,E={focus:"focusin",blur:"focusout"},w={mouseenter:"mouseover",mouseleave:"mouseout"};g.click=g.mousedown=g.mouseup=g.mousemove="MouseEvents",e.event={add:a,remove:c},e.proxy=function(t,i){var o=2 in arguments&&d.call(arguments,2);if(p(t)){var r=function(){return t.apply(i,o?o.concat(d.call(arguments)):arguments)};return r._zid=n(t),r}if(m(i))return o?(o.unshift(t[i],t),e.proxy.apply(null,o)):e.proxy(t[i],t);throw new TypeError("expected function")},e.fn.bind=function(t,e,n){return this.on(t,e,n)},e.fn.unbind=function(t,e){return this.off(t,e)},e.fn.one=function(t,e,n,i){return this.on(t,e,n,i,1)};var b=function(){return!0},x=function(){return!1},T=/^([A-Z]|returnValue$|layer[XY]$|webkitMovement[XY]$)/,C={preventDefault:"isDefaultPrevented",stopImmediatePropagation:"isImmediatePropagationStopped",stopPropagation:"isPropagationStopped"};e.fn.delegate=function(t,e,n){return this.on(e,t,n)},e.fn.undelegate=function(t,e,n){return this.off(e,t,n)},e.fn.live=function(t,n){return e(document.body).delegate(this.selector,t,n),this},e.fn.die=function(t,n){return e(document.body).undelegate(this.selector,t,n),this},e.fn.on=function(t,n,i,o,r){var s,u,f=this;return t&&!m(t)?(e.each(t,function(t,e){f.on(t,n,i,e,r)}),f):(m(n)||p(o)||!1===o||(o=i,i=n,n=h),(o===h||!1===i)&&(o=i,i=h),!1===o&&(o=x),f.each(function(h,f){r&&(s=function(t){return c(f,t.type,o),o.apply(this,arguments)}),n&&(u=function(t){var i,r=e(t.target).closest(n,f).get(0);return r&&r!==f?(i=e.extend(l(t),{currentTarget:r,liveFired:f}),(s||o).apply(r,[i].concat(d.call(arguments,1)))):void 0}),a(f,t,o,i,n,u||s)}))},e.fn.off=function(t,n,i){var o=this;return t&&!m(t)?(e.each(t,function(t,e){o.off(t,n,e)}),o):(m(n)||p(i)||!1===i||(i=n,n=h),!1===i&&(i=x),o.each(function(){c(this,t,i,n)}))},e.fn.trigger=function(t,n){return t=m(t)||e.isPlainObject(t)?e.Event(t):u(t),t._args=n,this.each(function(){t.type in E&&"function"==typeof this[t.type]?this[t.type]():"dispatchEvent"in this?this.dispatchEvent(t):e(this).triggerHandler(t,n)})},e.fn.triggerHandler=function(t,n){var o,r;return this.each(function(s,a){(o=l(m(t)?e.Event(t):t))._args=n,o.target=a,e.each(i(a,t.type||t),function(t,e){return r=e.proxy(o),!o.isImmediatePropagationStopped()&&void 0})}),r},"focusin focusout focus blur load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select keydown keypress keyup error".split(" ").forEach(function(t){e.fn[t]=function(e){return 0 in arguments?this.bind(t,e):this.trigger(t)}}),e.Event=function(t,e){m(t)||(e=t,t=e.type);var n=document.createEvent(g[t]||"Events"),i=!0;if(e)for(var o in e)"bubbles"==o?i=!!e[o]:n[o]=e[o];return n.initEvent(t,i,!0),u(n)}}(e),function(e){function n(t,n,i,o){return t.global?function(t,n,i){var o=e.Event(n);return e(t).trigger(o,i),!o.isDefaultPrevented()}(n||p,i,o):void 0}function i(t,e){var i=e.context;return!1!==e.beforeSend.call(i,t,e)&&!1!==n(e,i,"ajaxBeforeSend",[t,e])&&void n(e,i,"ajaxSend",[t,e])}function o(t,e,i,o){var r=i.context;i.success.call(r,t,"success",e),o&&o.resolveWith(r,[t,"success",e]),n(i,r,"ajaxSuccess",[e,i,t]),s("success",e,i)}function r(t,e,i,o,r){var a=o.context;o.error.call(a,i,e,t),r&&r.rejectWith(a,[i,e,t]),n(o,a,"ajaxError",[i,o,t||e]),s(e,i,o)}function s(t,i,o){var r=o.context;o.complete.call(r,i,t),n(o,r,"ajaxComplete",[i,o]),function(t){t.global&&!--e.active&&n(t,null,"ajaxStop")}(o)}function a(){}function c(t,e){return""==e?t:(t+"&"+e).replace(/[&?]{1,2}/,"?")}function u(t,n,i,o){return e.isFunction(n)&&(o=i,i=n,n=void 0),e.isFunction(i)||(o=i,i=void 0),{url:t,data:n,success:i,dataType:o}}function l(t,n,i,o){var r,s=e.isArray(n),a=e.isPlainObject(n);e.each(n,function(n,c){r=e.type(c),o&&(n=i?o:o+"["+(a||"object"==r||"array"==r?n:"")+"]"),!o&&s?t.add(c.name,c.value):"array"==r||!i&&"object"==r?l(t,c,i,n):t.add(n,c)})}var h,f,d=+new Date,p=t.document,m=/<script\b[^<]*(?:(?!<\/script>)<[^<]*)*<\/script>/gi,v=/^(?:text|application)\/javascript/i,g=/^(?:text|application)\/xml/i,y="application/json",E="text/html",w=/^\s*$/,b=p.createElement("a");b.href=t.location.href,e.active=0,e.ajaxJSONP=function(n,s){if(!("type"in n))return e.ajax(n);var a,c,u=n.jsonpCallback,l=(e.isFunction(u)?u():u)||"Zepto"+d++,h=p.createElement("script"),f=t[l],m=function(t){e(h).triggerHandler("error",t||"abort")},v={abort:m};return s&&s.promise(v),e(h).on("load error",function(i,u){clearTimeout(c),e(h).off().remove(),"error"!=i.type&&a?o(a[0],v,n,s):r(null,u||"error",v,n,s),t[l]=f,a&&e.isFunction(f)&&f(a[0]),f=a=void 0}),!1===i(v,n)?(m("abort"),v):(t[l]=function(){a=arguments},h.src=n.url.replace(/\?(.+)=\?/,"?$1="+l),p.head.appendChild(h),n.timeout>0&&(c=setTimeout(function(){m("timeout")},n.timeout)),v)},e.ajaxSettings={type:"GET",beforeSend:a,success:a,error:a,complete:a,context:null,global:!0,xhr:function(){return new t.XMLHttpRequest},accepts:{script:"text/javascript, application/javascript, application/x-javascript",json:y,xml:"application/xml, text/xml",html:E,text:"text/plain"},crossDomain:!1,timeout:0,processData:!0,cache:!0,dataFilter:a},e.ajax=function(s){var u,l,d=e.extend({},s||{}),m=e.Deferred&&e.Deferred();for(h in e.ajaxSettings)void 0===d[h]&&(d[h]=e.ajaxSettings[h]);(function(t){t.global&&0==e.active++&&n(t,null,"ajaxStart")})(d),d.crossDomain||(u=p.createElement("a"),u.href=d.url,u.href=u.href,d.crossDomain=b.protocol+"//"+b.host!=u.protocol+"//"+u.host),d.url||(d.url=t.location.toString()),(l=d.url.indexOf("#"))>-1&&(d.url=d.url.slice(0,l)),function(t){t.processData&&t.data&&"string"!=e.type(t.data)&&(t.data=e.param(t.data,t.traditional)),!t.data||t.type&&"GET"!=t.type.toUpperCase()&&"jsonp"!=t.dataType||(t.url=c(t.url,t.data),t.data=void 0)}(d);var x=d.dataType,T=/\?.+=\?/.test(d.url);if(T&&(x="jsonp"),!1!==d.cache&&(s&&!0===s.cache||"script"!=x&&"jsonp"!=x)||(d.url=c(d.url,"_="+Date.now())),"jsonp"==x)return T||(d.url=c(d.url,d.jsonp?d.jsonp+"=?":!1===d.jsonp?"":"callback=?")),e.ajaxJSONP(d,m);var C,k=d.accepts[x],S={},D=function(t,e){S[t.toLowerCase()]=[t,e]},L=/^([\w-]+:)\/\//.test(d.url)?RegExp.$1:t.location.protocol,N=d.xhr(),j=N.setRequestHeader;if(m&&m.promise(N),d.crossDomain||D("X-Requested-With","XMLHttpRequest"),D("Accept",k||"*/*"),(k=d.mimeType||k)&&(k.indexOf(",")>-1&&(k=k.split(",",2)[0]),N.overrideMimeType&&N.overrideMimeType(k)),(d.contentType||!1!==d.contentType&&d.data&&"GET"!=d.type.toUpperCase())&&D("Content-Type",d.contentType||"application/x-www-form-urlencoded"),d.headers)for(f in d.headers)D(f,d.headers[f]);if(N.setRequestHeader=D,N.onreadystatechange=function(){if(4==N.readyState){N.onreadystatechange=a,clearTimeout(C);var t,n=!1;if(N.status>=200&&N.status<300||304==N.status||0==N.status&&"file:"==L){if(x=x||function(t){return t&&(t=t.split(";",2)[0]),t&&(t==E?"html":t==y?"json":v.test(t)?"script":g.test(t)&&"xml")||"text"}(d.mimeType||N.getResponseHeader("content-type")),"arraybuffer"==N.responseType||"blob"==N.responseType)t=N.response;else{t=N.responseText;try{t=function(t,e,n){if(n.dataFilter==a)return t;var i=n.context;return n.dataFilter.call(i,t,e)}(t,x,d),"script"==x?(0,eval)(t):"xml"==x?t=N.responseXML:"json"==x&&(t=w.test(t)?null:e.parseJSON(t))}catch(t){n=t}if(n)return r(n,"parsererror",N,d,m)}o(t,N,d,m)}else r(N.statusText||null,N.status?"error":"abort",N,d,m)}},!1===i(N,d))return N.abort(),r(null,"abort",N,d,m),N;var A=!("async"in d)||d.async;if(N.open(d.type,d.url,A,d.username,d.password),d.xhrFields)for(f in d.xhrFields)N[f]=d.xhrFields[f];for(f in S)j.apply(N,S[f]);return d.timeout>0&&(C=setTimeout(function(){N.onreadystatechange=a,N.abort(),r(null,"timeout",N,d,m)},d.timeout)),N.send(d.data?d.data:null),N},e.get=function(){return e.ajax(u.apply(null,arguments))},e.post=function(){var t=u.apply(null,arguments);return t.type="POST",e.ajax(t)},e.getJSON=function(){var t=u.apply(null,arguments);return t.dataType="json",e.ajax(t)},e.fn.load=function(t,n,i){if(!this.length)return this;var o,r=this,s=t.split(/\s/),a=u(t,n,i),c=a.success;return s.length>1&&(a.url=s[0],o=s[1]),a.success=function(t){r.html(o?e("<div>").html(t.replace(m,"")).find(o):t),c&&c.apply(r,arguments)},e.ajax(a),this};var x=encodeURIComponent;e.param=function(t,n){var i=[];return i.add=function(t,n){e.isFunction(n)&&(n=n()),null==n&&(n=""),this.push(x(t)+"="+x(n))},l(i,t,n),i.join("&").replace(/%20/g,"+")}}(e),function(t){t.fn.serializeArray=function(){var e,n,i=[],o=function(t){return t.forEach?t.forEach(o):void i.push({name:e,value:t})};return this[0]&&t.each(this[0].elements,function(i,r){n=r.type,(e=r.name)&&"fieldset"!=r.nodeName.toLowerCase()&&!r.disabled&&"submit"!=n&&"reset"!=n&&"button"!=n&&"file"!=n&&("radio"!=n&&"checkbox"!=n||r.checked)&&o(t(r).val())}),i},t.fn.serialize=function(){var t=[];return this.serializeArray().forEach(function(e){t.push(encodeURIComponent(e.name)+"="+encodeURIComponent(e.value))}),t.join("&")},t.fn.submit=function(e){if(0 in arguments)this.bind("submit",e);else if(this.length){var n=t.Event("submit");this.eq(0).trigger(n),n.isDefaultPrevented()||this.get(0).submit()}return this}}(e),function(){try{getComputedStyle(void 0)}catch(n){var e=getComputedStyle;t.getComputedStyle=function(t,n){try{return e(t,n)}catch(t){return null}}}}(),e}),function(){"use strict";function t(e,i){function o(t,e){return function(){return t.apply(e,arguments)}}var r;if(i=i||{},this.trackingClick=!1,this.trackingClickStart=0,this.targetElement=null,this.touchStartX=0,this.touchStartY=0,this.lastTouchIdentifier=0,this.touchBoundary=i.touchBoundary||10,this.layer=e,this.tapDelay=i.tapDelay||200,this.tapTimeout=i.tapTimeout||700,!t.notNeeded(e)){for(var s=["onMouse","onClick","onTouchStart","onTouchMove","onTouchEnd","onTouchCancel"],a=0,c=s.length;a<c;a++)this[s[a]]=o(this[s[a]],this);n&&(e.addEventListener("mouseover",this.onMouse,!0),e.addEventListener("mousedown",this.onMouse,!0),e.addEventListener("mouseup",this.onMouse,!0)),e.addEventListener("click",this.onClick,!0),e.addEventListener("touchstart",this.onTouchStart,!1),e.addEventListener("touchmove",this.onTouchMove,!1),e.addEventListener("touchend",this.onTouchEnd,!1),e.addEventListener("touchcancel",this.onTouchCancel,!1),Event.prototype.stopImmediatePropagation||(e.removeEventListener=function(t,n,i){var o=Node.prototype.removeEventListener;"click"===t?o.call(e,t,n.hijacked||n,i):o.call(e,t,n,i)},e.addEventListener=function(t,n,i){var o=Node.prototype.addEventListener;"click"===t?o.call(e,t,n.hijacked||(n.hijacked=function(t){t.propagationStopped||n(t)}),i):o.call(e,t,n,i)}),"function"==typeof e.onclick&&(r=e.onclick,e.addEventListener("click",function(t){r(t)},!1),e.onclick=null)}}var e=navigator.userAgent.indexOf("Windows Phone")>=0,n=navigator.userAgent.indexOf("Android")>0&&!e,i=/iP(ad|hone|od)/.test(navigator.userAgent)&&!e,o=i&&/OS 4_\d(_\d)?/.test(navigator.userAgent),r=i&&/OS [6-7]_\d/.test(navigator.userAgent),s=navigator.userAgent.indexOf("BB10")>0;t.prototype.needsClick=function(t){switch(t.nodeName.toLowerCase()){case"button":case"select":case"textarea":if(t.disabled)return!0;break;case"input":if(i&&"file"===t.type||t.disabled)return!0;break;case"label":case"iframe":case"video":return!0}return/\bneedsclick\b/.test(t.className)},t.prototype.needsFocus=function(t){switch(t.nodeName.toLowerCase()){case"textarea":return!0;case"select":return!n;case"input":switch(t.type){case"button":case"checkbox":case"file":case"image":case"radio":case"submit":return!1}return!t.disabled&&!t.readOnly;default:return/\bneedsfocus\b/.test(t.className)}},t.prototype.sendClick=function(t,e){var n,i;document.activeElement&&document.activeElement!==t&&document.activeElement.blur(),i=e.changedTouches[0],(n=document.createEvent("MouseEvents")).initMouseEvent(this.determineEventType(t),!0,!0,window,1,i.screenX,i.screenY,i.clientX,i.clientY,!1,!1,!1,!1,0,null),n.forwardedTouchEvent=!0,t.dispatchEvent(n)},t.prototype.determineEventType=function(t){return n&&"select"===t.tagName.toLowerCase()?"mousedown":"click"},t.prototype.focus=function(t){var e;i&&t.setSelectionRange&&0!==t.type.indexOf("date")&&"time"!==t.type&&"month"!==t.type&&"email"!==t.type?(e=t.value.length,t.setSelectionRange(e,e)):t.focus()},t.prototype.updateScrollParent=function(t){var e,n;if(!(e=t.fastClickScrollParent)||!e.contains(t)){n=t;do{if(n.scrollHeight>n.offsetHeight){e=n,t.fastClickScrollParent=n;break}n=n.parentElement}while(n)}e&&(e.fastClickLastScrollTop=e.scrollTop)},t.prototype.getTargetElementFromEventTarget=function(t){return t.nodeType===Node.TEXT_NODE?t.parentNode:t},t.prototype.onTouchStart=function(t){var e,n,r;if(t.targetTouches.length>1)return!0;if(e=this.getTargetElementFromEventTarget(t.target),n=t.targetTouches[0],i){if((r=window.getSelection()).rangeCount&&!r.isCollapsed)return!0;if(!o){if(n.identifier&&n.identifier===this.lastTouchIdentifier)return t.preventDefault(),!1;this.lastTouchIdentifier=n.identifier,this.updateScrollParent(e)}}return this.trackingClick=!0,this.trackingClickStart=t.timeStamp,this.targetElement=e,this.touchStartX=n.pageX,this.touchStartY=n.pageY,t.timeStamp-this.lastClickTime<this.tapDelay&&t.preventDefault(),!0},t.prototype.touchHasMoved=function(t){var e=t.changedTouches[0],n=this.touchBoundary;return Math.abs(e.pageX-this.touchStartX)>n||Math.abs(e.pageY-this.touchStartY)>n},t.prototype.onTouchMove=function(t){return!this.trackingClick||((this.targetElement!==this.getTargetElementFromEventTarget(t.target)||this.touchHasMoved(t))&&(this.trackingClick=!1,this.targetElement=null),!0)},t.prototype.findControl=function(t){return void 0!==t.control?t.control:t.htmlFor?document.getElementById(t.htmlFor):t.querySelector("button, input:not([type=hidden]), keygen, meter, output, progress, select, textarea")},t.prototype.onTouchEnd=function(t){var e,s,a,c,u,l=this.targetElement;if(!this.trackingClick)return!0;if(t.timeStamp-this.lastClickTime<this.tapDelay)return this.cancelNextClick=!0,!0;if(t.timeStamp-this.trackingClickStart>this.tapTimeout)return!0;if(this.cancelNextClick=!1,this.lastClickTime=t.timeStamp,s=this.trackingClickStart,this.trackingClick=!1,this.trackingClickStart=0,r&&(u=t.changedTouches[0],(l=document.elementFromPoint(u.pageX-window.pageXOffset,u.pageY-window.pageYOffset)||l).fastClickScrollParent=this.targetElement.fastClickScrollParent),"label"===(a=l.tagName.toLowerCase())){if(e=this.findControl(l)){if(this.focus(l),n)return!1;l=e}}else if(this.needsFocus(l))return t.timeStamp-s>100||i&&window.top!==window&&"input"===a?(this.targetElement=null,!1):(this.focus(l),this.sendClick(l,t),i&&"select"===a||(this.targetElement=null,t.preventDefault()),!1);return!(!i||o||!(c=l.fastClickScrollParent)||c.fastClickLastScrollTop===c.scrollTop)||(this.needsClick(l)||(t.preventDefault(),this.sendClick(l,t)),!1)},t.prototype.onTouchCancel=function(){this.trackingClick=!1,this.targetElement=null},t.prototype.onMouse=function(t){return!this.targetElement||(!!t.forwardedTouchEvent||(!t.cancelable||(!(!this.needsClick(this.targetElement)||this.cancelNextClick)||(t.stopImmediatePropagation?t.stopImmediatePropagation():t.propagationStopped=!0,t.stopPropagation(),t.preventDefault(),!1))))},t.prototype.onClick=function(t){var e;return this.trackingClick?(this.targetElement=null,this.trackingClick=!1,!0):"submit"===t.target.type&&0===t.detail||((e=this.onMouse(t))||(this.targetElement=null),e)},t.prototype.destroy=function(){var t=this.layer;n&&(t.removeEventListener("mouseover",this.onMouse,!0),t.removeEventListener("mousedown",this.onMouse,!0),t.removeEventListener("mouseup",this.onMouse,!0)),t.removeEventListener("click",this.onClick,!0),t.removeEventListener("touchstart",this.onTouchStart,!1),t.removeEventListener("touchmove",this.onTouchMove,!1),t.removeEventListener("touchend",this.onTouchEnd,!1),t.removeEventListener("touchcancel",this.onTouchCancel,!1)},t.notNeeded=function(t){var e,i,o;if(void 0===window.ontouchstart)return!0;if(i=+(/Chrome\/([0-9]+)/.exec(navigator.userAgent)||[,0])[1]){if(!n)return!0;if(e=document.querySelector("meta[name=viewport]")){if(-1!==e.content.indexOf("user-scalable=no"))return!0;if(i>31&&document.documentElement.scrollWidth<=window.outerWidth)return!0}}if(s&&(o=navigator.userAgent.match(/Version\/([0-9]*)\.([0-9]*)/))[1]>=10&&o[2]>=3&&(e=document.querySelector("meta[name=viewport]"))){if(-1!==e.content.indexOf("user-scalable=no"))return!0;if(document.documentElement.scrollWidth<=window.outerWidth)return!0}return"none"===t.style.msTouchAction||"manipulation"===t.style.touchAction||(!!(+(/Firefox\/([0-9]+)/.exec(navigator.userAgent)||[,0])[1]>=27&&(e=document.querySelector("meta[name=viewport]"))&&(-1!==e.content.indexOf("user-scalable=no")||document.documentElement.scrollWidth<=window.outerWidth))||"none"===t.style.touchAction||"manipulation"===t.style.touchAction)},t.attach=function(e,n){return new t(e,n)},"function"==typeof define&&"object"==typeof define.amd&&define.amd?define(function(){return t}):"undefined"!=typeof module&&module.exports?(module.exports=t.attach,module.exports.FastClick=t):window.FastClick=t}(),function(t){"use strict";function e(t){t.touches||(t.touches=t.originalEvent.touches)}function n(t){t.opts.autoLoad&&t._scrollContentHeight-t._threshold<=t._scrollWindowHeight&&o(t)}function i(t){t._scrollContentHeight=t.opts.scrollArea==a?l.height():t.$element[0].scrollHeight}function o(t){t.direction="up",t.$domDown.html(t.opts.domDown.domLoad),t.loading=!0,t.opts.loadDownFn(t)}function r(t,e){t.css({"-webkit-transition":"all "+e+"ms",transition:"all "+e+"ms"})}var s,a=window,c=document,u=t(a),l=t(c);t.fn.dropload=function(t){return new s(this,t)},(s=function(t,e){this.$element=t,this.upInsertDOM=!1,this.loading=!1,this.isLockUp=!1,this.isLockDown=!1,this.isData=!0,this._scrollTop=0,this._threshold=0,this.init(e)}).prototype.init=function(i){var s=this;s.opts=t.extend(!0,{},{scrollArea:s.$element,domUp:{domClass:"dropload-up",domRefresh:'<div class="dropload-refresh">↓下拉刷新</div>',domUpdate:'<div class="dropload-update">↑释放更新</div>',domLoad:'<div class="dropload-load"><span class="loading"></span>加载中...</div>'},domDown:{domClass:"dropload-down",domRefresh:'<div class="dropload-refresh">↑上拉加载更多</div>',domLoad:'<div class="dropload-load"><span class="loading"></span>加载中...</div>',domNoData:'<div class="dropload-noData">暂无数据</div>'},autoLoad:!0,distance:50,threshold:"",loadUpFn:"",loadDownFn:""},i),""!=s.opts.loadDownFn&&(s.$element.append('<div class="'+s.opts.domDown.domClass+'">'+s.opts.domDown.domRefresh+"</div>"),s.$domDown=t("."+s.opts.domDown.domClass)),s._threshold=s.$domDown&&""===s.opts.threshold?Math.floor(1*s.$domDown.height()/3):s.opts.threshold,s.opts.scrollArea==a?(s.$scrollArea=u,s._scrollContentHeight=l.height(),s._scrollWindowHeight=c.documentElement.clientHeight):(s.$scrollArea=s.opts.scrollArea,s._scrollContentHeight=s.$element[0].scrollHeight,s._scrollWindowHeight=s.$element.height()),n(s),u.on("resize",function(){s._scrollWindowHeight=s.opts.scrollArea==a?a.innerHeight:s.$element.height()}),s.$element.on("touchstart",function(t){s.loading||(e(t),function(t,e){e._startY=t.touches[0].pageY,e.touchScrollTop=e.$scrollArea.scrollTop()}(t,s))}),s.$element.on("touchmove",function(n){s.loading||(e(n),function(e,n){n._curY=e.touches[0].pageY,n._moveY=n._curY-n._startY,n._moveY>0?n.direction="down":n._moveY<0&&(n.direction="up");var i=Math.abs(n._moveY);""!=n.opts.loadUpFn&&n.touchScrollTop<=0&&"down"==n.direction&&!n.isLockUp&&(e.preventDefault(),n.$domUp=t("."+n.opts.domUp.domClass),n.upInsertDOM||(n.$element.prepend('<div class="'+n.opts.domUp.domClass+'"></div>'),n.upInsertDOM=!0),r(n.$domUp,0),i<=n.opts.distance?(n._offsetY=i,n.$domUp.html(n.opts.domUp.domRefresh)):i>n.opts.distance&&i<=2*n.opts.distance?(n._offsetY=n.opts.distance+.5*(i-n.opts.distance),n.$domUp.html(n.opts.domUp.domUpdate)):n._offsetY=n.opts.distance+.5*n.opts.distance+.2*(i-2*n.opts.distance),n.$domUp.css({height:n._offsetY}))}(n,s))}),s.$element.on("touchend",function(){s.loading||function(e){var n=Math.abs(e._moveY);""!=e.opts.loadUpFn&&e.touchScrollTop<=0&&"down"==e.direction&&!e.isLockUp&&(r(e.$domUp,300),n>e.opts.distance?(e.$domUp.css({height:e.$domUp.children().height()}),e.$domUp.html(e.opts.domUp.domLoad),e.loading=!0,e.opts.loadUpFn(e)):e.$domUp.css({height:"0"}).on("webkitTransitionEnd mozTransitionEnd transitionend",function(){e.upInsertDOM=!1,t(this).remove()}),e._moveY=0)}(s)}),s.$scrollArea.on("scroll",function(){s._scrollTop=s.$scrollArea.scrollTop(),""!=s.opts.loadDownFn&&!s.loading&&!s.isLockDown&&s._scrollContentHeight-s._threshold<=s._scrollWindowHeight+s._scrollTop&&o(s)})},s.prototype.lock=function(t){void 0===t?"up"==this.direction?this.isLockDown=!0:"down"==this.direction?this.isLockUp=!0:(this.isLockUp=!0,this.isLockDown=!0):"up"==t?this.isLockUp=!0:"down"==t&&(this.isLockDown=!0,this.direction="up")},s.prototype.unlock=function(){this.isLockUp=!1,this.isLockDown=!1,this.direction="up"},s.prototype.noData=function(t){void 0===t||1==t?this.isData=!1:0==t&&(this.isData=!0)},s.prototype.resetload=function(){var e=this;"down"==e.direction&&e.upInsertDOM?e.$domUp.css({height:"0"}).on("webkitTransitionEnd mozTransitionEnd transitionend",function(){e.loading=!1,e.upInsertDOM=!1,t(this).remove(),i(e)}):"up"==e.direction&&(e.loading=!1,e.isData?(e.$domDown.html(e.opts.domDown.domRefresh),i(e),n(e)):e.$domDown.html(e.opts.domDown.domNoData))}}(window.Zepto||window.jQuery);var tempRoot="http://api2.mircalcure.com/zlapi",imgRoot="http://upload2.mircalcure.com/tumourfile/sysfile/getPicFile.do?fileId=",smallImgRoot="http://upload2.mircalcure.com/tumourfile/sysfile/getImage/3/",ARTICLE_URL="http://cms.mircalcure.com",baseUrl="http://118.178.135.207:9008/zlapi/",isRelease=!0,isMobile={Windows:function(){return/IEMobile/i.test(navigator.userAgent)},Android:function(){return/Android/i.test(navigator.userAgent)},BlackBerry:function(){return/BlackBerry/i.test(navigator.userAgent)},iOS:function(){return/iPhone|iPad|iPod/i.test(navigator.userAgent)},any:function(){return isMobile.Android()||isMobile.BlackBerry()||isMobile.iOS()||isMobile.Windows()}};