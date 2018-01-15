!function(t,e){"function"==typeof define&&define.amd?define(function(){return e(t)}):e(t)}(this,function(t){var e=function(){function e(t){return null==t?String(t):H[_.call(t)]||"object"}function n(t){return"function"==e(t)}function r(t){return null!=t&&t==t.window}function i(t){return null!=t&&t.nodeType==t.DOCUMENT_NODE}function o(t){return"object"==e(t)}function a(t){return o(t)&&!r(t)&&Object.getPrototypeOf(t)==Object.prototype}function s(t){var e=!!t&&"length"in t&&t.length,n=x.type(t);return"function"!=n&&!r(t)&&("array"==n||0===e||"number"==typeof e&&e>0&&e-1 in t)}function u(t){return t.replace(/::/g,"/").replace(/([A-Z]+)([A-Z][a-z])/g,"$1_$2").replace(/([a-z\d])([A-Z])/g,"$1_$2").replace(/_/g,"-").toLowerCase()}function c(t){return t in A?A[t]:A[t]=new RegExp("(^|\\s)"+t+"(\\s|$)")}function l(t,e){return"number"!=typeof e||D[u(t)]?e:e+"px"}function f(t){return"children"in t?N.call(t.children):x.map(t.childNodes,function(t){return 1==t.nodeType?t:void 0})}function h(t,e){var n,r=t?t.length:0;for(n=0;r>n;n++)this[n]=t[n];this.length=r,this.selector=e||""}function p(t,e){return null==e?x(t):x(t).filter(e)}function d(t,e,r,i){return n(e)?e.call(t,r,i):e}function m(t,e,n){null==n?t.removeAttribute(e):t.setAttribute(e,n)}function v(t,e){var n=t.className||"",r=n&&n.baseVal!==y;return e===y?r?n.baseVal:n:void(r?n.baseVal=e:t.className=e)}function g(t){try{return t?"true"==t||"false"!=t&&("null"==t?null:+t+""==t?+t:/^[\[\{]/.test(t)?x.parseJSON(t):t):t}catch(e){return t}}var y,b,x,E,j,T,w=[],S=w.concat,C=w.filter,N=w.slice,P=t.document,O={},A={},D={"column-count":1,columns:1,"font-weight":1,"line-height":1,opacity:1,"z-index":1,zoom:1},R=/^\s*<(\w+|!)[^>]*>/,L=/^<(\w+)\s*\/?>(?:<\/\1>|)$/,M=/<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi,$=/^(?:body|html)$/i,k=/([A-Z])/g,F=["val","css","html","text","data","width","height","offset"],z=P.createElement("table"),I=P.createElement("tr"),Z={tr:P.createElement("tbody"),tbody:z,thead:z,tfoot:z,td:I,th:I,"*":P.createElement("div")},B=/complete|loaded|interactive/,q=/^[\w-]*$/,H={},_=H.toString,V={},U=P.createElement("div"),X={tabindex:"tabIndex",readonly:"readOnly",for:"htmlFor",class:"className",maxlength:"maxLength",cellspacing:"cellSpacing",cellpadding:"cellPadding",rowspan:"rowSpan",colspan:"colSpan",usemap:"useMap",frameborder:"frameBorder",contenteditable:"contentEditable"},J=Array.isArray||function(t){return t instanceof Array};return V.matches=function(t,e){if(!e||!t||1!==t.nodeType)return!1;var n=t.matches||t.webkitMatchesSelector||t.mozMatchesSelector||t.oMatchesSelector||t.matchesSelector;if(n)return n.call(t,e);var r,i=t.parentNode,o=!i;return o&&(i=U).appendChild(t),r=~V.qsa(i,e).indexOf(t),o&&U.removeChild(t),r},j=function(t){return t.replace(/-+(.)?/g,function(t,e){return e?e.toUpperCase():""})},T=function(t){return C.call(t,function(e,n){return t.indexOf(e)==n})},V.fragment=function(t,e,n){var r,i,o;return L.test(t)&&(r=x(P.createElement(RegExp.$1))),r||(t.replace&&(t=t.replace(M,"<$1></$2>")),e===y&&(e=R.test(t)&&RegExp.$1),e in Z||(e="*"),o=Z[e],o.innerHTML=""+t,r=x.each(N.call(o.childNodes),function(){o.removeChild(this)})),a(n)&&(i=x(r),x.each(n,function(t,e){F.indexOf(t)>-1?i[t](e):i.attr(t,e)})),r},V.Z=function(t,e){return new h(t,e)},V.isZ=function(t){return t instanceof V.Z},V.init=function(t,e){var r;if(!t)return V.Z();if("string"==typeof t)if(t=t.trim(),"<"==t[0]&&R.test(t))r=V.fragment(t,RegExp.$1,e),t=null;else{if(e!==y)return x(e).find(t);r=V.qsa(P,t)}else{if(n(t))return x(P).ready(t);if(V.isZ(t))return t;if(J(t))i=t,r=C.call(i,function(t){return null!=t});else if(o(t))r=[t],t=null;else if(R.test(t))r=V.fragment(t.trim(),RegExp.$1,e),t=null;else{if(e!==y)return x(e).find(t);r=V.qsa(P,t)}}var i;return V.Z(r,t)},(x=function(t,e){return V.init(t,e)}).extend=function(t){var e,n=N.call(arguments,1);return"boolean"==typeof t&&(e=t,t=n.shift()),n.forEach(function(n){!function t(e,n,r){for(b in n)r&&(a(n[b])||J(n[b]))?(a(n[b])&&!a(e[b])&&(e[b]={}),J(n[b])&&!J(e[b])&&(e[b]=[]),t(e[b],n[b],r)):n[b]!==y&&(e[b]=n[b])}(t,n,e)}),t},V.qsa=function(t,e){var n,r="#"==e[0],i=!r&&"."==e[0],o=r||i?e.slice(1):e,a=q.test(o);return t.getElementById&&a&&r?(n=t.getElementById(o))?[n]:[]:1!==t.nodeType&&9!==t.nodeType&&11!==t.nodeType?[]:N.call(a&&!r&&t.getElementsByClassName?i?t.getElementsByClassName(o):t.getElementsByTagName(e):t.querySelectorAll(e))},x.contains=P.documentElement.contains?function(t,e){return t!==e&&t.contains(e)}:function(t,e){for(;e&&(e=e.parentNode);)if(e===t)return!0;return!1},x.type=e,x.isFunction=n,x.isWindow=r,x.isArray=J,x.isPlainObject=a,x.isEmptyObject=function(t){var e;for(e in t)return!1;return!0},x.isNumeric=function(t){var e=Number(t),n=typeof t;return null!=t&&"boolean"!=n&&("string"!=n||t.length)&&!isNaN(e)&&isFinite(e)||!1},x.inArray=function(t,e,n){return w.indexOf.call(e,t,n)},x.camelCase=j,x.trim=function(t){return null==t?"":String.prototype.trim.call(t)},x.uuid=0,x.support={},x.expr={},x.noop=function(){},x.map=function(t,e){var n,r,i,o=[];if(s(t))for(r=0;r<t.length;r++)n=e(t[r],r),null!=n&&o.push(n);else for(i in t)n=e(t[i],i),null!=n&&o.push(n);return(a=o).length>0?x.fn.concat.apply([],a):a;var a},x.each=function(t,e){var n,r;if(s(t)){for(n=0;n<t.length;n++)if(!1===e.call(t[n],n,t[n]))return t}else for(r in t)if(!1===e.call(t[r],r,t[r]))return t;return t},x.grep=function(t,e){return C.call(t,e)},t.JSON&&(x.parseJSON=JSON.parse),x.each("Boolean Number String Function Array Date RegExp Object Error".split(" "),function(t,e){H["[object "+e+"]"]=e.toLowerCase()}),x.fn={constructor:V.Z,length:0,forEach:w.forEach,reduce:w.reduce,push:w.push,sort:w.sort,splice:w.splice,indexOf:w.indexOf,concat:function(){var t,e,n=[];for(t=0;t<arguments.length;t++)e=arguments[t],n[t]=V.isZ(e)?e.toArray():e;return S.apply(V.isZ(this)?this.toArray():this,n)},map:function(t){return x(x.map(this,function(e,n){return t.call(e,n,e)}))},slice:function(){return x(N.apply(this,arguments))},ready:function(t){return B.test(P.readyState)&&P.body?t(x):P.addEventListener("DOMContentLoaded",function(){t(x)},!1),this},get:function(t){return t===y?N.call(this):this[t>=0?t:t+this.length]},toArray:function(){return this.get()},size:function(){return this.length},remove:function(){return this.each(function(){null!=this.parentNode&&this.parentNode.removeChild(this)})},each:function(t){return w.every.call(this,function(e,n){return!1!==t.call(e,n,e)}),this},filter:function(t){return n(t)?this.not(this.not(t)):x(C.call(this,function(e){return V.matches(e,t)}))},add:function(t,e){return x(T(this.concat(x(t,e))))},is:function(t){return this.length>0&&V.matches(this[0],t)},not:function(t){var e=[];if(n(t)&&t.call!==y)this.each(function(n){t.call(this,n)||e.push(this)});else{var r="string"==typeof t?this.filter(t):s(t)&&n(t.item)?N.call(t):x(t);this.forEach(function(t){r.indexOf(t)<0&&e.push(t)})}return x(e)},has:function(t){return this.filter(function(){return o(t)?x.contains(this,t):x(this).find(t).size()})},eq:function(t){return-1===t?this.slice(t):this.slice(t,+t+1)},first:function(){var t=this[0];return t&&!o(t)?t:x(t)},last:function(){var t=this[this.length-1];return t&&!o(t)?t:x(t)},find:function(t){var e=this;return t?"object"==typeof t?x(t).filter(function(){var t=this;return w.some.call(e,function(e){return x.contains(e,t)})}):1==this.length?x(V.qsa(this[0],t)):this.map(function(){return V.qsa(this,t)}):x()},closest:function(t,e){var n=[],r="object"==typeof t&&x(t);return this.each(function(o,a){for(;a&&!(r?r.indexOf(a)>=0:V.matches(a,t));)a=a!==e&&!i(a)&&a.parentNode;a&&n.indexOf(a)<0&&n.push(a)}),x(n)},parents:function(t){for(var e=[],n=this;n.length>0;)n=x.map(n,function(t){return(t=t.parentNode)&&!i(t)&&e.indexOf(t)<0?(e.push(t),t):void 0});return p(e,t)},parent:function(t){return p(T(this.pluck("parentNode")),t)},children:function(t){return p(this.map(function(){return f(this)}),t)},contents:function(){return this.map(function(){return this.contentDocument||N.call(this.childNodes)})},siblings:function(t){return p(this.map(function(t,e){return C.call(f(e.parentNode),function(t){return t!==e})}),t)},empty:function(){return this.each(function(){this.innerHTML=""})},pluck:function(t){return x.map(this,function(e){return e[t]})},show:function(){return this.each(function(){"none"==this.style.display&&(this.style.display=""),"none"==getComputedStyle(this,"").getPropertyValue("display")&&(this.style.display=function(t){var e,n;return O[t]||(e=P.createElement(t),P.body.appendChild(e),n=getComputedStyle(e,"").getPropertyValue("display"),e.parentNode.removeChild(e),"none"==n&&(n="block"),O[t]=n),O[t]}(this.nodeName))})},replaceWith:function(t){return this.before(t).remove()},wrap:function(t){var e=n(t);if(this[0]&&!e)var r=x(t).get(0),i=r.parentNode||this.length>1;return this.each(function(n){x(this).wrapAll(e?t.call(this,n):i?r.cloneNode(!0):r)})},wrapAll:function(t){if(this[0]){x(this[0]).before(t=x(t));for(var e;(e=t.children()).length;)t=e.first();x(t).append(this)}return this},wrapInner:function(t){var e=n(t);return this.each(function(n){var r=x(this),i=r.contents(),o=e?t.call(this,n):t;i.length?i.wrapAll(o):r.append(o)})},unwrap:function(){return this.parent().each(function(){x(this).replaceWith(x(this).children())}),this},clone:function(){return this.map(function(){return this.cloneNode(!0)})},hide:function(){return this.css("display","none")},toggle:function(t){return this.each(function(){var e=x(this);(t===y?"none"==e.css("display"):t)?e.show():e.hide()})},prev:function(t){return x(this.pluck("previousElementSibling")).filter(t||"*")},next:function(t){return x(this.pluck("nextElementSibling")).filter(t||"*")},html:function(t){return 0 in arguments?this.each(function(e){var n=this.innerHTML;x(this).empty().append(d(this,t,e,n))}):0 in this?this[0].innerHTML:null},text:function(t){return 0 in arguments?this.each(function(e){var n=d(this,t,e,this.textContent);this.textContent=null==n?"":""+n}):0 in this?this.pluck("textContent").join(""):null},attr:function(t,e){var n;return"string"!=typeof t||1 in arguments?this.each(function(n){if(1===this.nodeType)if(o(t))for(b in t)m(this,b,t[b]);else m(this,t,d(this,e,n,this.getAttribute(t)))}):0 in this&&1==this[0].nodeType&&null!=(n=this[0].getAttribute(t))?n:y},removeAttr:function(t){return this.each(function(){1===this.nodeType&&t.split(" ").forEach(function(t){m(this,t)},this)})},prop:function(t,e){return t=X[t]||t,1 in arguments?this.each(function(n){this[t]=d(this,e,n,this[t])}):this[0]&&this[0][t]},removeProp:function(t){return t=X[t]||t,this.each(function(){delete this[t]})},data:function(t,e){var n="data-"+t.replace(k,"-$1").toLowerCase(),r=1 in arguments?this.attr(n,e):this.attr(n);return null!==r?g(r):y},val:function(t){return 0 in arguments?(null==t&&(t=""),this.each(function(e){this.value=d(this,t,e,this.value)})):this[0]&&(this[0].multiple?x(this[0]).find("option").filter(function(){return this.selected}).pluck("value"):this[0].value)},offset:function(e){if(e)return this.each(function(t){var n=x(this),r=d(this,e,t,n.offset()),i=n.offsetParent().offset(),o={top:r.top-i.top,left:r.left-i.left};"static"==n.css("position")&&(o.position="relative"),n.css(o)});if(!this.length)return null;if(P.documentElement!==this[0]&&!x.contains(P.documentElement,this[0]))return{top:0,left:0};var n=this[0].getBoundingClientRect();return{left:n.left+t.pageXOffset,top:n.top+t.pageYOffset,width:Math.round(n.width),height:Math.round(n.height)}},css:function(t,n){if(arguments.length<2){var r=this[0];if("string"==typeof t){if(!r)return;return r.style[j(t)]||getComputedStyle(r,"").getPropertyValue(t)}if(J(t)){if(!r)return;var i={},o=getComputedStyle(r,"");return x.each(t,function(t,e){i[e]=r.style[j(e)]||o.getPropertyValue(e)}),i}}var a="";if("string"==e(t))n||0===n?a=u(t)+":"+l(t,n):this.each(function(){this.style.removeProperty(u(t))});else for(b in t)t[b]||0===t[b]?a+=u(b)+":"+l(b,t[b])+";":this.each(function(){this.style.removeProperty(u(b))});return this.each(function(){this.style.cssText+=";"+a})},index:function(t){return t?this.indexOf(x(t)[0]):this.parent().children().indexOf(this[0])},hasClass:function(t){return!!t&&w.some.call(this,function(t){return this.test(v(t))},c(t))},addClass:function(t){return t?this.each(function(e){if("className"in this){E=[];var n=v(this);d(this,t,e,n).split(/\s+/g).forEach(function(t){x(this).hasClass(t)||E.push(t)},this),E.length&&v(this,n+(n?" ":"")+E.join(" "))}}):this},removeClass:function(t){return this.each(function(e){if("className"in this){if(t===y)return v(this,"");E=v(this),d(this,t,e,E).split(/\s+/g).forEach(function(t){E=E.replace(c(t)," ")}),v(this,E.trim())}})},toggleClass:function(t,e){return t?this.each(function(n){var r=x(this);d(this,t,n,v(this)).split(/\s+/g).forEach(function(t){(e===y?!r.hasClass(t):e)?r.addClass(t):r.removeClass(t)})}):this},scrollTop:function(t){if(this.length){var e="scrollTop"in this[0];return t===y?e?this[0].scrollTop:this[0].pageYOffset:this.each(e?function(){this.scrollTop=t}:function(){this.scrollTo(this.scrollX,t)})}},scrollLeft:function(t){if(this.length){var e="scrollLeft"in this[0];return t===y?e?this[0].scrollLeft:this[0].pageXOffset:this.each(e?function(){this.scrollLeft=t}:function(){this.scrollTo(t,this.scrollY)})}},position:function(){if(this.length){var t=this[0],e=this.offsetParent(),n=this.offset(),r=$.test(e[0].nodeName)?{top:0,left:0}:e.offset();return n.top-=parseFloat(x(t).css("margin-top"))||0,n.left-=parseFloat(x(t).css("margin-left"))||0,r.top+=parseFloat(x(e[0]).css("border-top-width"))||0,r.left+=parseFloat(x(e[0]).css("border-left-width"))||0,{top:n.top-r.top,left:n.left-r.left}}},offsetParent:function(){return this.map(function(){for(var t=this.offsetParent||P.body;t&&!$.test(t.nodeName)&&"static"==x(t).css("position");)t=t.offsetParent;return t})}},x.fn.detach=x.fn.remove,["width","height"].forEach(function(t){var e=t.replace(/./,function(t){return t[0].toUpperCase()});x.fn[t]=function(n){var o,a=this[0];return n===y?r(a)?a["inner"+e]:i(a)?a.documentElement["scroll"+e]:(o=this.offset())&&o[t]:this.each(function(e){(a=x(this)).css(t,d(this,n,e,a[t]()))})}}),["after","prepend","before","append"].forEach(function(n,r){var i=r%2;x.fn[n]=function(){var n,o,a=x.map(arguments,function(t){var r=[];return"array"==(n=e(t))?(t.forEach(function(t){return t.nodeType!==y?r.push(t):x.zepto.isZ(t)?r=r.concat(t.get()):void(r=r.concat(V.fragment(t)))}),r):"object"==n||null==t?t:V.fragment(t)}),s=this.length>1;return a.length<1?this:this.each(function(e,n){o=i?n:n.parentNode,n=0==r?n.nextSibling:1==r?n.firstChild:2==r?n:null;var u=x.contains(P.documentElement,o);a.forEach(function(e){if(s)e=e.cloneNode(!0);else if(!o)return x(e).remove();o.insertBefore(e,n),u&&function t(e,n){n(e);for(var r=0,i=e.childNodes.length;i>r;r++)t(e.childNodes[r],n)}(e,function(e){if(!(null==e.nodeName||"SCRIPT"!==e.nodeName.toUpperCase()||e.type&&"text/javascript"!==e.type||e.src)){var n=e.ownerDocument?e.ownerDocument.defaultView:t;n.eval.call(n,e.innerHTML)}})})})},x.fn[i?n+"To":"insert"+(r?"Before":"After")]=function(t){return x(t)[n](this),this}}),V.Z.prototype=h.prototype=x.fn,V.uniq=T,V.deserializeValue=g,x.zepto=V,x}();return t.Zepto=e,void 0===t.$&&(t.$=e),function(e){function n(t){return t._zid||(t._zid=h++)}function r(t,e,r,o){if((e=i(e)).ns)var a=(s=e.ns,new RegExp("(?:^| )"+s.replace(" "," .* ?")+"(?: |$)"));var s;return(v[n(t)]||[]).filter(function(t){return t&&(!e.e||t.e==e.e)&&(!e.ns||a.test(t.ns))&&(!r||n(t.fn)===n(r))&&(!o||t.sel==o)})}function i(t){var e=(""+t).split(".");return{e:e[0],ns:e.slice(1).sort().join(" ")}}function o(t,e){return t.del&&!y&&t.e in b||!!e}function a(t){return x[t]||y&&b[t]||t}function s(t,r,s,u,l,h,p){var d=n(t),m=v[d]||(v[d]=[]);r.split(/\s/).forEach(function(n){if("ready"==n)return e(document).ready(s);var r=i(n);r.fn=s,r.sel=l,r.e in x&&(s=function(t){var n=t.relatedTarget;return!n||n!==this&&!e.contains(this,n)?r.fn.apply(this,arguments):void 0}),r.del=h;var d=h||s;r.proxy=function(e){if(!(e=c(e)).isImmediatePropagationStopped()){e.data=u;var n=d.apply(t,e._args==f?[e]:[e].concat(e._args));return!1===n&&(e.preventDefault(),e.stopPropagation()),n}},r.i=m.length,m.push(r),"addEventListener"in t&&t.addEventListener(a(r.e),r.proxy,o(r,p))})}function u(t,e,i,s,u){var c=n(t);(e||"").split(/\s/).forEach(function(e){r(t,e,i,s).forEach(function(e){delete v[c][e.i],"removeEventListener"in t&&t.removeEventListener(a(e.e),e.proxy,o(e,u))})})}function c(t,n){return(n||!t.isDefaultPrevented)&&(n||(n=t),e.each(w,function(e,r){var i=n[e];t[e]=function(){return this[r]=E,i&&i.apply(n,arguments)},t[r]=j}),t.timeStamp||(t.timeStamp=Date.now()),(n.defaultPrevented!==f?n.defaultPrevented:"returnValue"in n?!1===n.returnValue:n.getPreventDefault&&n.getPreventDefault())&&(t.isDefaultPrevented=E)),t}function l(t){var e,n={originalEvent:t};for(e in t)T.test(e)||t[e]===f||(n[e]=t[e]);return c(n,t)}var f,h=1,p=Array.prototype.slice,d=e.isFunction,m=function(t){return"string"==typeof t},v={},g={},y="onfocusin"in t,b={focus:"focusin",blur:"focusout"},x={mouseenter:"mouseover",mouseleave:"mouseout"};g.click=g.mousedown=g.mouseup=g.mousemove="MouseEvents",e.event={add:s,remove:u},e.proxy=function(t,r){var i=2 in arguments&&p.call(arguments,2);if(d(t)){var o=function(){return t.apply(r,i?i.concat(p.call(arguments)):arguments)};return o._zid=n(t),o}if(m(r))return i?(i.unshift(t[r],t),e.proxy.apply(null,i)):e.proxy(t[r],t);throw new TypeError("expected function")},e.fn.bind=function(t,e,n){return this.on(t,e,n)},e.fn.unbind=function(t,e){return this.off(t,e)},e.fn.one=function(t,e,n,r){return this.on(t,e,n,r,1)};var E=function(){return!0},j=function(){return!1},T=/^([A-Z]|returnValue$|layer[XY]$|webkitMovement[XY]$)/,w={preventDefault:"isDefaultPrevented",stopImmediatePropagation:"isImmediatePropagationStopped",stopPropagation:"isPropagationStopped"};e.fn.delegate=function(t,e,n){return this.on(e,t,n)},e.fn.undelegate=function(t,e,n){return this.off(e,t,n)},e.fn.live=function(t,n){return e(document.body).delegate(this.selector,t,n),this},e.fn.die=function(t,n){return e(document.body).undelegate(this.selector,t,n),this},e.fn.on=function(t,n,r,i,o){var a,c,h=this;return t&&!m(t)?(e.each(t,function(t,e){h.on(t,n,r,e,o)}),h):(m(n)||d(i)||!1===i||(i=r,r=n,n=f),(i===f||!1===r)&&(i=r,r=f),!1===i&&(i=j),h.each(function(f,h){o&&(a=function(t){return u(h,t.type,i),i.apply(this,arguments)}),n&&(c=function(t){var r,o=e(t.target).closest(n,h).get(0);return o&&o!==h?(r=e.extend(l(t),{currentTarget:o,liveFired:h}),(a||i).apply(o,[r].concat(p.call(arguments,1)))):void 0}),s(h,t,i,r,n,c||a)}))},e.fn.off=function(t,n,r){var i=this;return t&&!m(t)?(e.each(t,function(t,e){i.off(t,n,e)}),i):(m(n)||d(r)||!1===r||(r=n,n=f),!1===r&&(r=j),i.each(function(){u(this,t,r,n)}))},e.fn.trigger=function(t,n){return(t=m(t)||e.isPlainObject(t)?e.Event(t):c(t))._args=n,this.each(function(){t.type in b&&"function"==typeof this[t.type]?this[t.type]():"dispatchEvent"in this?this.dispatchEvent(t):e(this).triggerHandler(t,n)})},e.fn.triggerHandler=function(t,n){var i,o;return this.each(function(a,s){(i=l(m(t)?e.Event(t):t))._args=n,i.target=s,e.each(r(s,t.type||t),function(t,e){return o=e.proxy(i),!i.isImmediatePropagationStopped()&&void 0})}),o},"focusin focusout focus blur load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select keydown keypress keyup error".split(" ").forEach(function(t){e.fn[t]=function(e){return 0 in arguments?this.bind(t,e):this.trigger(t)}}),e.Event=function(t,e){m(t)||(e=t,t=e.type);var n=document.createEvent(g[t]||"Events"),r=!0;if(e)for(var i in e)"bubbles"==i?r=!!e[i]:n[i]=e[i];return n.initEvent(t,r,!0),c(n)}}(e),function(e){function n(t,n,r,i){return t.global?function(t,n,r){var i=e.Event(n);return e(t).trigger(i,r),!i.isDefaultPrevented()}(n||p,r,i):void 0}function r(t,e){var r=e.context;return!1!==e.beforeSend.call(r,t,e)&&!1!==n(e,r,"ajaxBeforeSend",[t,e])&&void n(e,r,"ajaxSend",[t,e])}function i(t,e,r,i){var o=r.context;r.success.call(o,t,"success",e),i&&i.resolveWith(o,[t,"success",e]),n(r,o,"ajaxSuccess",[e,r,t]),a("success",e,r)}function o(t,e,r,i,o){var s=i.context;i.error.call(s,r,e,t),o&&o.rejectWith(s,[r,e,t]),n(i,s,"ajaxError",[r,i,t||e]),a(e,r,i)}function a(t,r,i){var o=i.context;i.complete.call(o,r,t),n(i,o,"ajaxComplete",[r,i]),(a=i).global&&!--e.active&&n(a,null,"ajaxStop");var a}function s(){}function u(t,e){return""==e?t:(t+"&"+e).replace(/[&?]{1,2}/,"?")}function c(t,n,r,i){return e.isFunction(n)&&(i=r,r=n,n=void 0),e.isFunction(r)||(i=r,r=void 0),{url:t,data:n,success:r,dataType:i}}var l,f,h=+new Date,p=t.document,d=/<script\b[^<]*(?:(?!<\/script>)<[^<]*)*<\/script>/gi,m=/^(?:text|application)\/javascript/i,v=/^(?:text|application)\/xml/i,g="application/json",y="text/html",b=/^\s*$/,x=p.createElement("a");x.href=t.location.href,e.active=0,e.ajaxJSONP=function(n,a){if(!("type"in n))return e.ajax(n);var s,u,c=n.jsonpCallback,l=(e.isFunction(c)?c():c)||"Zepto"+h++,f=p.createElement("script"),d=t[l],m=function(t){e(f).triggerHandler("error",t||"abort")},v={abort:m};return a&&a.promise(v),e(f).on("load error",function(r,c){clearTimeout(u),e(f).off().remove(),"error"!=r.type&&s?i(s[0],v,n,a):o(null,c||"error",v,n,a),t[l]=d,s&&e.isFunction(d)&&d(s[0]),d=s=void 0}),!1===r(v,n)?(m("abort"),v):(t[l]=function(){s=arguments},f.src=n.url.replace(/\?(.+)=\?/,"?$1="+l),p.head.appendChild(f),n.timeout>0&&(u=setTimeout(function(){m("timeout")},n.timeout)),v)},e.ajaxSettings={type:"GET",beforeSend:s,success:s,error:s,complete:s,context:null,global:!0,xhr:function(){return new t.XMLHttpRequest},accepts:{script:"text/javascript, application/javascript, application/x-javascript",json:g,xml:"application/xml, text/xml",html:y,text:"text/plain"},crossDomain:!1,timeout:0,processData:!0,cache:!0,dataFilter:s},e.ajax=function(a){var c,h,d=e.extend({},a||{}),E=e.Deferred&&e.Deferred();for(l in e.ajaxSettings)void 0===d[l]&&(d[l]=e.ajaxSettings[l]);(T=d).global&&0==e.active++&&n(T,null,"ajaxStart"),d.crossDomain||(c=p.createElement("a"),c.href=d.url,c.href=c.href,d.crossDomain=x.protocol+"//"+x.host!=c.protocol+"//"+c.host),d.url||(d.url=t.location.toString()),(h=d.url.indexOf("#"))>-1&&(d.url=d.url.slice(0,h)),(j=d).processData&&j.data&&"string"!=e.type(j.data)&&(j.data=e.param(j.data,j.traditional)),!j.data||j.type&&"GET"!=j.type.toUpperCase()&&"jsonp"!=j.dataType||(j.url=u(j.url,j.data),j.data=void 0);var j,T,w=d.dataType,S=/\?.+=\?/.test(d.url);if(S&&(w="jsonp"),!1!==d.cache&&(a&&!0===a.cache||"script"!=w&&"jsonp"!=w)||(d.url=u(d.url,"_="+Date.now())),"jsonp"==w)return S||(d.url=u(d.url,d.jsonp?d.jsonp+"=?":!1===d.jsonp?"":"callback=?")),e.ajaxJSONP(d,E);var C,N=d.accepts[w],P={},O=function(t,e){P[t.toLowerCase()]=[t,e]},A=/^([\w-]+:)\/\//.test(d.url)?RegExp.$1:t.location.protocol,D=d.xhr(),R=D.setRequestHeader;if(E&&E.promise(D),d.crossDomain||O("X-Requested-With","XMLHttpRequest"),O("Accept",N||"*/*"),(N=d.mimeType||N)&&(N.indexOf(",")>-1&&(N=N.split(",",2)[0]),D.overrideMimeType&&D.overrideMimeType(N)),(d.contentType||!1!==d.contentType&&d.data&&"GET"!=d.type.toUpperCase())&&O("Content-Type",d.contentType||"application/x-www-form-urlencoded"),d.headers)for(f in d.headers)O(f,d.headers[f]);if(D.setRequestHeader=O,D.onreadystatechange=function(){if(4==D.readyState){D.onreadystatechange=s,clearTimeout(C);var t,n=!1;if(D.status>=200&&D.status<300||304==D.status||0==D.status&&"file:"==A){if(w=w||(r=d.mimeType||D.getResponseHeader("content-type"),r&&(r=r.split(";",2)[0]),r&&(r==y?"html":r==g?"json":m.test(r)?"script":v.test(r)&&"xml")||"text"),"arraybuffer"==D.responseType||"blob"==D.responseType)t=D.response;else{t=D.responseText;try{t=function(t,e,n){if(n.dataFilter==s)return t;var r=n.context;return n.dataFilter.call(r,t,e)}(t,w,d),"script"==w?(0,eval)(t):"xml"==w?t=D.responseXML:"json"==w&&(t=b.test(t)?null:e.parseJSON(t))}catch(t){n=t}if(n)return o(n,"parsererror",D,d,E)}i(t,D,d,E)}else o(D.statusText||null,D.status?"error":"abort",D,d,E)}var r},!1===r(D,d))return D.abort(),o(null,"abort",D,d,E),D;var L=!("async"in d)||d.async;if(D.open(d.type,d.url,L,d.username,d.password),d.xhrFields)for(f in d.xhrFields)D[f]=d.xhrFields[f];for(f in P)R.apply(D,P[f]);return d.timeout>0&&(C=setTimeout(function(){D.onreadystatechange=s,D.abort(),o(null,"timeout",D,d,E)},d.timeout)),D.send(d.data?d.data:null),D},e.get=function(){return e.ajax(c.apply(null,arguments))},e.post=function(){var t=c.apply(null,arguments);return t.type="POST",e.ajax(t)},e.getJSON=function(){var t=c.apply(null,arguments);return t.dataType="json",e.ajax(t)},e.fn.load=function(t,n,r){if(!this.length)return this;var i,o=this,a=t.split(/\s/),s=c(t,n,r),u=s.success;return a.length>1&&(s.url=a[0],i=a[1]),s.success=function(t){o.html(i?e("<div>").html(t.replace(d,"")).find(i):t),u&&u.apply(o,arguments)},e.ajax(s),this};var E=encodeURIComponent;e.param=function(t,n){var r=[];return r.add=function(t,n){e.isFunction(n)&&(n=n()),null==n&&(n=""),this.push(E(t)+"="+E(n))},function t(n,r,i,o){var a,s=e.isArray(r),u=e.isPlainObject(r);e.each(r,function(r,c){a=e.type(c),o&&(r=i?o:o+"["+(u||"object"==a||"array"==a?r:"")+"]"),!o&&s?n.add(c.name,c.value):"array"==a||!i&&"object"==a?t(n,c,i,r):n.add(r,c)})}(r,t,n),r.join("&").replace(/%20/g,"+")}}(e),(n=e).fn.serializeArray=function(){var t,e,r=[],i=function(e){return e.forEach?e.forEach(i):void r.push({name:t,value:e})};return this[0]&&n.each(this[0].elements,function(r,o){e=o.type,(t=o.name)&&"fieldset"!=o.nodeName.toLowerCase()&&!o.disabled&&"submit"!=e&&"reset"!=e&&"button"!=e&&"file"!=e&&("radio"!=e&&"checkbox"!=e||o.checked)&&i(n(o).val())}),r},n.fn.serialize=function(){var t=[];return this.serializeArray().forEach(function(e){t.push(encodeURIComponent(e.name)+"="+encodeURIComponent(e.value))}),t.join("&")},n.fn.submit=function(t){if(0 in arguments)this.bind("submit",t);else if(this.length){var e=n.Event("submit");this.eq(0).trigger(e),e.isDefaultPrevented()||this.get(0).submit()}return this},function(){try{getComputedStyle(void 0)}catch(n){var e=getComputedStyle;t.getComputedStyle=function(t,n){try{return e(t,n)}catch(t){return null}}}}(),e;var n});var imgRoot1="http://upload.mircalcure.com/tumourfile/sysfile/getPicFile.do?fileId=",tempRoot="http://api2.mircalcure.com/zlapi",imgRoot="http://upload2.mircalcure.com/tumourfile/sysfile/getPicFile.do?fileId=",smallImgRoot="http://upload2.mircalcure.com/tumourfile/sysfile/getImage/3/",ARTICLE_URL="http://cms.mircalcure.com",baseUrl="http://118.178.135.207:9008/zlapi/",isRelease=!0;function stringReturnNull(t){return t||"暂无"}var isMobile={Windows:function(){return/IEMobile/i.test(navigator.userAgent)},Android:function(){return/Android/i.test(navigator.userAgent)},BlackBerry:function(){return/BlackBerry/i.test(navigator.userAgent)},iOS:function(){return/iPhone|iPad|iPod/i.test(navigator.userAgent)},any:function(){return isMobile.Android()||isMobile.BlackBerry()||isMobile.iOS()||isMobile.Windows()}};