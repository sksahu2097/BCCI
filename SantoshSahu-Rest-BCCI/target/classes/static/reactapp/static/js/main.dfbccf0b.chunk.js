(this["webpackJsonpmy-app"]=this["webpackJsonpmy-app"]||[]).push([[0],{34:function(e,t,a){e.exports=a(62)},62:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),c=a(32),s=a.n(c),l=a(19),o=a(2),u=a(3),i=a(5),h=a(4),m=a(7),d=a(1),p=a.n(d),f=a(6);var E=function(e){return r.a.createElement("tr",null,r.a.createElement("td",null,e.firstcolumn),r.a.createElement("td",null,e.secondcolumn),r.a.createElement("td",null,e.thirdcolumn),r.a.createElement("td",null,e.fourthcolumn))},v=a(8),g=a.n(v);var b=function(e){return r.a.createElement("thead",null,r.a.createElement("tr",null,r.a.createElement("th",null,e.firstcolumn),r.a.createElement("th",null,e.secondcolumn),r.a.createElement("th",null,e.thirdcolumn),r.a.createElement("th",null,e.fourthcolumn)))},C=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){var e;return Object(o.a)(this,a),(e=t.call(this)).fetchData=Object(f.a)(p.a.mark((function t(){var a;return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.get("http://localhost:8080/winsoft/BCCI/series");case 2:a=t.sent,e.setState({series:a.data});case 4:case"end":return t.stop()}}),t)}))),e.state={series:[]},e}return Object(u.a)(a,[{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("button",{onClick:this.fetchData,className:"btn"},"get Data"),r.a.createElement("div",null,r.a.createElement("table",null,r.a.createElement(b,{firstcolumn:"Series Id",secondcolumn:"Series Name",thirdcolumn:"Start Date",fourthcolumn:"End Date"}),r.a.createElement("tbody",null,this.state.series.map((function(e){return r.a.createElement(E,{key:e.series_id,firstcolumn:e.series_id,secondcolumn:e.series_name,thirdcolumn:e.start_date,fourthcolumn:e.end_date})}))))))}}]),a}(r.a.Component),w=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){var e;return Object(o.a)(this,a),(e=t.call(this)).fetchData=Object(f.a)(p.a.mark((function t(){var a;return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.get("http://localhost:8080/winsoft/BCCI/match");case 2:a=t.sent,console.warn(a.data),e.setState({match:a.data});case 5:case"end":return t.stop()}}),t)}))),e.state={match:[]},e}return Object(u.a)(a,[{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("button",{onClick:this.fetchData},"get Data"),r.a.createElement("div",null,r.a.createElement("table",null,r.a.createElement(b,{firstcolumn:"team1",secondcolumn:"team2",thirdcolumn:"city",fourthcolumn:"match_date"}),r.a.createElement("tbody",null,this.state.match.map((function(e){return r.a.createElement(E,{key:e.match_id,firstcolumn:e.team1,secondcolumn:e.team2,thirdcolumn:e.city,fourthcolumn:e.date})}))))))}}]),a}(r.a.Component),y=a(10);var j=function(e){return r.a.createElement("option",{value:e.value},e.name)},O=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){var e;return Object(o.a)(this,a),(e=t.call(this)).fetchData=function(){var t=Object(f.a)(p.a.mark((function t(a){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.get("http://localhost:8080/winsoft/BCCI/matches/series/".concat(a)).then((function(t){console.warn(t.data),console.warn(t.data.length),e.setState({match:t.data,resposelength:t.data.length})})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header),window.alert("No matches found in this series = "+e.response.status))}));case 2:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),e.handleChange=function(){var t=Object(f.a)(p.a.mark((function t(a){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,e.setState({value:a.target.value});case 2:console.log("selected Series  = "+e.state.value),e.fetchData(e.state.value);case 4:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),e.state={match:[],series:[],value:"",resposelength:"0"},e.handleChange=e.handleChange.bind(Object(y.a)(e)),e}return Object(u.a)(a,[{key:"componentDidMount",value:function(){var e=this;fetch("http://localhost:8080/winsoft/BCCI/series").then((function(t){t.json().then((function(t){console.warn(t),e.setState({series:t})}))}))}},{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("select",{value:this.state.value,onChange:this.handleChange},this.state.series.map((function(e){return r.a.createElement(j,{key:e.series_id,value:e.series_id,name:e.series_name})}))),r.a.createElement("div",null,r.a.createElement("table",null,r.a.createElement(b,{firstcolumn:"Team 1",secondcolumn:"Team 2",thirdcolumn:"City Name",fourthcolumn:"Match Date"}),r.a.createElement("tbody",null,this.state.match.map((function(e){return r.a.createElement(E,{key:e.match_id,firstcolumn:e.team1,secondcolumn:e.team2,thirdcolumn:e.city,fourthcolumn:e.date})}))))))}}]),a}(r.a.Component),_=a(15),k=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){var e;return Object(o.a)(this,a),(e=t.call(this)).saveData=Object(f.a)(p.a.mark((function t(){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.post("http://localhost:8080/winsoft/BCCI/series",{series_name:e.state.series_name,start_date:e.state.start_date,end_date:e.state.end_date,matches:[]},{headers:{"content-type":"application/json"}}).then((function(e){console.warn(e.data),console.warn(e.data.length),window.alert(e.data)})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header),window.alert("some error occurred = "+e.response.status))}));case 2:case"end":return t.stop()}}),t)}))),e.state={series_name:"",start_date:"",end_date:""},e.handleInputChange=e.handleInputChange.bind(Object(y.a)(e)),e}return Object(u.a)(a,[{key:"handleInputChange",value:function(e){var t=e.target.value,a=e.target.name;this.setState(Object(_.a)({},a,t)),console.warn(a+" "+t)}},{key:"render",value:function(){return r.a.createElement("div",{className:"bg-wrap-series"},r.a.createElement("div",{className:"wrap-series"},r.a.createElement("form",{className:"createseries"},r.a.createElement("span",{className:"contact2-form-title"},"Create Series"),r.a.createElement("input",{type:"text",className:"createseriesinput",id:"series_name",placeholder:"series name",onChange:this.handleInputChange,name:"series_name",value:this.state.series_name}),r.a.createElement("input",{type:"date",min:"2020-01-01",max:"2020-12-31",className:"createseriesinput",name:"start_date",id:"start_date",placeholder:"start date",value:this.state.start_date,onChange:this.handleInputChange}),r.a.createElement("input",{type:"date",className:"createseriesinput",min:"2020-01-01",max:"2020-12-31",id:"end_date",placeholder:"end_date",name:"end_date",value:this.state.end_date,onChange:this.handleInputChange}),r.a.createElement("button",{className:"btn",onClick:this.saveData},"Save Data"))))}}]),a}(r.a.Component),S=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){var e;return Object(o.a)(this,a),(e=t.call(this)).handleChange=function(){var t=Object(f.a)(p.a.mark((function t(a){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,e.setState({series_id:a.target.value});case 2:console.log(e.state.series_id);case 3:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),e.saveData=Object(f.a)(p.a.mark((function t(){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return window.alert("clicked"),t.next=3,g.a.post("http://localhost:8080/winsoft/BCCI/match/".concat(e.state.series_id),{team1:e.state.team1,team2:e.state.team2,city:e.state.city,date:e.state.date},{headers:{"content-type":"application/json"}}).then((function(e){console.warn(e.data),console.warn(e.data.length),window.alert(e.data)})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header),window.alert("some error occurred = "+e.response.status))}));case 3:window.alert("some error occurred = ");case 4:case"end":return t.stop()}}),t)}))),e.state={team1:"",team2:"",city:"",date:"",series_id:"",series:[]},e.handleInputChange=e.handleInputChange.bind(Object(y.a)(e)),e}return Object(u.a)(a,[{key:"handleInputChange",value:function(e){var t=e.target.value,a=e.target.name;this.setState(Object(_.a)({},a,t)),console.warn(a+" "+t)}},{key:"componentDidMount",value:function(){var e=this;fetch("http://localhost:8080/winsoft/BCCI/series").then((function(t){t.json().then((function(t){console.warn(t),e.setState({series:t})}))}))}},{key:"render",value:function(){return r.a.createElement("div",{className:"bg-wrap-series"},r.a.createElement("div",{className:"wrap-series"},r.a.createElement("form",{className:"createseries"},r.a.createElement("span",{className:"contact2-form-title"},"Create Match By Series Id"),r.a.createElement("input",{type:"text",className:"createseriesinput",id:"team1",placeholder:"Team 1 Name",onChange:this.handleInputChange,name:"team1",value:this.state.team1}),r.a.createElement("input",{type:"text",className:"createseriesinput",id:"team2",placeholder:"Team 2 Name",onChange:this.handleInputChange,name:"team2",value:this.state.team2}),r.a.createElement("input",{type:"text",className:"createseriesinput",id:"city",placeholder:"City Name",onChange:this.handleInputChange,name:"city",value:this.state.city}),r.a.createElement("input",{type:"date",className:"createseriesinput",min:"2020-01-01",max:"2020-12-31",id:"date",name:"date",value:this.state.date,onChange:this.handleInputChange}),r.a.createElement("div",null,r.a.createElement("label",{className:"selectser"},"Select Series"),r.a.createElement("select",{value:this.state.value,onChange:this.handleChange,className:"selectOption"},this.state.series.map((function(e){return r.a.createElement(j,{key:e.series_id,value:e.series_id,name:e.series_name})}))),r.a.createElement("br",null),r.a.createElement("br",null),r.a.createElement("button",{className:"btn",onClick:this.saveData},"Save Data")))))}}]),a}(r.a.Component),I=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(u.a)(a,[{key:"render",value:function(){return r.a.createElement("tr",null,r.a.createElement("td",null,r.a.createElement("input",{value:this.props.firstcolumn,onChange:this.props.handleInputChange,name:"series_id"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.secondcolumnValue,onChange:this.props.handleInputChange,name:"series_name"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.thirdcolumnValue,type:"date",onChange:this.props.handleInputChange,name:"start_date"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.fourthcolumnValue,type:"date",onChange:this.props.handleInputChange,name:"end_date"})))}}]),a}(r.a.Component),N=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){var e;return Object(o.a)(this,a),(e=t.call(this)).fetchData=function(){var t=Object(f.a)(p.a.mark((function t(a){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.get("http://localhost:8080/winsoft/BCCI/series/".concat(a)).then((function(t){console.warn(t.data),console.warn(t.data.length),e.setState({updateSeries:t.data}),e.setState({series_name:t.data[0].series_name,start_date:t.data[0].start_date,end_date:t.data[0].end_date}),console.log("series_name : "+t.data[0].series_name)})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header))}));case 2:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),e.saveUpdatedSeries=Object(f.a)(p.a.mark((function t(){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.put("http://localhost:8080/winsoft/BCCI/series/"+e.state.series_id,{series_name:e.state.series_name,start_date:e.state.start_date,end_date:e.state.end_date,series_id:e.state.series_id},{headers:{"content-type":"application/json"}}).then((function(e){console.warn(e.data),console.warn(e.data.length),window.alert(e.data)})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header),window.alert("some error occurred = "+e.response.status))}));case 2:case"end":return t.stop()}}),t)}))),e.deleteSeries=Object(f.a)(p.a.mark((function t(){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.delete("http://localhost:8080/winsoft/BCCI/series/"+e.state.series_id,{},{headers:{"content-type":"application/json"}}).then((function(e){console.warn(e.data),console.warn(e.data.length),window.alert(e.data)})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header),window.alert("some error occurred = "+e.response.status))}));case 2:case"end":return t.stop()}}),t)}))),e.handleChange=function(){var t=Object(f.a)(p.a.mark((function t(a){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,e.setState({series_id:a.target.value});case 2:console.log(e.state.series_id),e.fetchData(e.state.series_id);case 4:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),e.state={series_id:"",series:[],series_name:"",start_date:"",end_date:"",updateSeries:[]},e.handleChange=e.handleChange.bind(Object(y.a)(e)),e.handleInputChange=e.handleInputChange.bind(Object(y.a)(e)),e}return Object(u.a)(a,[{key:"componentDidMount",value:function(){var e=this;fetch("http://localhost:8080/winsoft/BCCI/series").then((function(t){t.json().then((function(t){console.warn(t),e.setState({series:t})}))}))}},{key:"handleInputChange",value:function(e){var t=e.target.value,a=e.target.name;console.warn(a+" "+t),this.setState(Object(_.a)({},a,t)),console.warn(a+" "+t)}},{key:"render",value:function(){var e=this;return r.a.createElement("div",{className:"container"},r.a.createElement("center",null,r.a.createElement("h1",null,"Update Series")),r.a.createElement("br",null),r.a.createElement("label",{className:"selectser"},"Select Series"),r.a.createElement("select",{value:this.state.value,onChange:this.handleChange,className:"selectOption"},this.state.series.map((function(e){return r.a.createElement(j,{key:e.series_id,value:e.series_id,name:e.series_name})}))),r.a.createElement("table",null,r.a.createElement(b,{firstcolumn:"Series Id",secondcolumn:"Series Name",thirdcolumn:"Start Date",fourthcolumn:"End Date",onChange:this}),r.a.createElement("tbody",null,this.state.updateSeries.map((function(t){return r.a.createElement(I,{key:t.series_id,handleInputChange:e.handleInputChange,firstcolumn:t.series_id,secondcolumnValue:e.state.series_name,thirdcolumnValue:e.state.start_date,fourthcolumnValue:e.state.end_date})})))),r.a.createElement("br",null),r.a.createElement("br",null),r.a.createElement("button",{className:"btn",onClick:this.saveUpdatedSeries},"Upate Series"),r.a.createElement("button",{className:"delbtn",onClick:this.deleteSeries},"Delete Series"))}}]),a}(r.a.Component);var x=function(e){return r.a.createElement("thead",null,r.a.createElement("tr",null,r.a.createElement("th",null,"select Status"),r.a.createElement("th",null,e.firstcolumn),r.a.createElement("th",null,e.secondcolumn),r.a.createElement("th",null,e.thirdcolumn),r.a.createElement("th",null,e.fourthcolumn),r.a.createElement("th",null,e.fifthcolumn)))},D=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(u.a)(a,[{key:"render",value:function(){return r.a.createElement("tr",null,r.a.createElement("td",null,r.a.createElement("label",null,r.a.createElement("input",{type:"checkbox",name:this.props.firstcolumn,onChange:this.props.handleCheckChange}))),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.firstcolumn,onChange:this.props.handleInputChange,name:"match_id"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.secondcolumnValue,onChange:this.props.handleInputChange,name:"team1"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.thirdcolumnValue,onChange:this.props.handleInputChange,name:"team2"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.fourthcolumnValue,onChange:this.props.handleInputChange,name:"city"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.fifthcolumnValue,type:"date",onChange:this.props.handleInputChange,name:"date"})))}}]),a}(r.a.Component),M=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(u.a)(a,[{key:"render",value:function(){return r.a.createElement("tr",null,r.a.createElement("td",null,r.a.createElement("input",{value:this.props.firstcolumn,onChange:this.props.handleInputChange,name:"match_id"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.secondcolumnValue,onChange:this.props.handleInputChange,name:"team1"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.thirdcolumnValue,onChange:this.props.handleInputChange,name:"team2"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.fourthcolumnValue,onChange:this.props.handleInputChange,name:"city"})),r.a.createElement("td",null,r.a.createElement("input",{value:this.props.fifthcolumnValue,type:"date",onChange:this.props.handleInputChange,name:"date"})))}}]),a}(r.a.Component);var V=function(e){return r.a.createElement("thead",null,r.a.createElement("tr",null,r.a.createElement("th",null,e.firstcolumn),r.a.createElement("th",null,e.secondcolumn),r.a.createElement("th",null,e.thirdcolumn),r.a.createElement("th",null,e.fourthcolumn),r.a.createElement("th",null,e.fifthcolumn)))},B=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){var e;return Object(o.a)(this,a),(e=t.call(this)).fetchData=function(){var t=Object(f.a)(p.a.mark((function t(a){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.get("http://localhost:8080/winsoft/BCCI/matches/series/".concat(a)).then((function(t){console.warn(t.data),console.warn(t.data.length),e.setState({match:t.data})})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header),window.alert("No matches found in this series = "+e.response.status))}));case 2:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),e.getData=function(){var t=Object(f.a)(p.a.mark((function t(a){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.get("http://localhost:8080/winsoft/BCCI/match/".concat(a)).then((function(t){console.warn(t.data),console.warn(t.data.length),e.setState({newMatch:t.data}),console.log(t.data.team1),e.setState({match_id:t.data[0].match_id,team1:t.data[0].team1,team2:t.data[0].team2,city:t.data[0].city,date:t.data[0].date})})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header),window.alert("No matches found in this series = "+e.response.status))}));case 2:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),e.saveUpdatedMatch=Object(f.a)(p.a.mark((function t(){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.put("http://localhost:8080/winsoft/BCCI/match/"+e.state.match_id,{team1:e.state.team1,team2:e.state.team2,city:e.state.city,date:e.state.date,match_id:e.state.match_id},{headers:{"content-type":"application/json"}}).then((function(e){console.warn(e.data),console.warn(e.data.length),window.alert(e.data)})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header),window.alert("some error occurred = "+e.response.status))}));case 2:case"end":return t.stop()}}),t)}))),e.deleteMatch=Object(f.a)(p.a.mark((function t(){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.delete("http://localhost:8080/winsoft/BCCI/match/"+e.state.match_id,{},{headers:{"content-type":"application/json"}}).then((function(e){console.warn(e.data),console.warn(e.data.length),window.alert(e.data)})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header),window.alert("some error occurred = "+e.response.status))}));case 2:case"end":return t.stop()}}),t)}))),e.handleChange=function(){var t=Object(f.a)(p.a.mark((function t(a){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,e.setState({series_id:a.target.value});case 2:console.log(e.state.series_id),e.fetchData(e.state.series_id);case 4:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),e.state={series_id:"",series:[],match:[],match_id:"",team1:"",team2:"",city:"",date:"",newMatch:[]},e.handleCheckChange=e.handleCheckChange.bind(Object(y.a)(e)),e.handleInputChange=e.handleInputChange.bind(Object(y.a)(e)),e}return Object(u.a)(a,[{key:"componentDidMount",value:function(){var e=this;fetch("http://localhost:8080/winsoft/BCCI/series").then((function(t){t.json().then((function(t){console.warn(t),e.setState({series:t})}))}))}},{key:"handleInputChange",value:function(e){var t=e.target.value,a=e.target.name;console.warn(a+" "+t),this.setState(Object(_.a)({},a,t)),console.warn(a+" "+t)}},{key:"handleCheckChange",value:function(e){var t=e.target.name;console.log("match ID = "+t),this.getData(t)}},{key:"render",value:function(){var e=this;return r.a.createElement("div",{className:"container"},r.a.createElement("center",null,r.a.createElement("h1",null,"Update Match By Series Id")),r.a.createElement("br",null),r.a.createElement("label",{className:"selectser"},"Select Series"),r.a.createElement("select",{value:this.state.value,onChange:this.handleChange,className:"selectOption"},this.state.series.map((function(e){return r.a.createElement(j,{key:e.series_id,value:e.series_id,name:e.series_name})}))),r.a.createElement("br",null),r.a.createElement("br",null),r.a.createElement("label",{className:"selectser"},"Select Match"),r.a.createElement("table",null,r.a.createElement(x,{firstcolumn:"MatchId",secondcolumn:"Team 1",thirdcolumn:"Team 2",fourthcolumn:"City Name",fifthcolumn:"Match Date"}),r.a.createElement("tbody",null,this.state.match.map((function(t){return r.a.createElement(D,{key:t.match_id,handleCheckChange:e.handleCheckChange,handleInputChange:e.handleInputChange,firstcolumn:t.match_id,secondcolumnValue:t.team1,thirdcolumnValue:t.team2,fourthcolumnValue:t.city,fifthcolumnValue:t.date})})))),r.a.createElement("br",null),r.a.createElement("br",null),r.a.createElement("label",{className:"selectser"},"Update The Suitable Information Match"),r.a.createElement("table",null,r.a.createElement(V,{firstcolumn:"MatchId",secondcolumn:"Team 1",thirdcolumn:"Team 2",fourthcolumn:"City Name",fifthcolumn:"Match Date"}),r.a.createElement("tbody",null,this.state.newMatch.map((function(t){return r.a.createElement(M,{key:t.match_id,handleInputChange:e.handleInputChange,firstcolumn:e.state.match_id,secondcolumnValue:e.state.team1,thirdcolumnValue:e.state.team2,fourthcolumnValue:e.state.city,fifthcolumnValue:e.state.date})})))),r.a.createElement("br",null),r.a.createElement("br",null),r.a.createElement("button",{className:"btn",onClick:this.saveUpdatedMatch},"Update Match"),r.a.createElement("button",{className:"delbtn",onClick:this.deleteMatch},"Delete Match"))}}]),a}(r.a.Component),U=a(11),T=Object(U.a)(),P=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(u.a)(a,[{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("h1",null,"Welcome To Master Pannel"),r.a.createElement("button",{className:"masterpannelbtn",onClick:function(){return T.push("SeriesMasterPanel")}}," Series"),r.a.createElement("button",{className:"masterpannelbtn",onClick:function(){return T.push("MatchMasterPanel")}}," Match"))}}]),a}(r.a.Component),W=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(u.a)(a,[{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("h1",null,"Welcome To Master Match Pannel"),r.a.createElement("button",{className:"matchmasterpannelbtn",onClick:function(){return T.push("GetMatchesBySeriesId")}},"Match Details"),r.a.createElement("button",{className:"matchmasterpannelbtn",onClick:function(){return T.push("UpdateMatch")}},"Update Match"),r.a.createElement("button",{className:"matchmasterpannelbtn",onClick:function(){return T.push("UpdateMatch")}},"Delete Match"),r.a.createElement("button",{className:"matchmasterpannelbtn",onClick:function(){return T.push("Prediction")}},"Predict Matches"))}}]),a}(r.a.Component),G=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(u.a)(a,[{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("h1",null,"Welcome To Series Match Pannel"),r.a.createElement("button",{className:"matchmasterpannelbtn",onClick:function(){return T.push("GetAllSeries")}},"Series Details"),r.a.createElement("button",{className:"matchmasterpannelbtn",onClick:function(){return T.push("UpdateSeries")}},"Update Series"),r.a.createElement("button",{className:"matchmasterpannelbtn",onClick:function(){return T.push("UpdateSeries")}},"Delete Series"),r.a.createElement("button",{className:"matchmasterpannelbtn",onClick:function(){return T.push("GetMatchesBySeriesId")}},"Match Details"))}}]),a}(r.a.Component);var A=function(e){return r.a.createElement("thead",null,r.a.createElement("tr",null,r.a.createElement("th",null,e.firstcolumn),r.a.createElement("th",null,e.secondcolumn),r.a.createElement("th",null,e.thirdcolumn),r.a.createElement("th",null,e.fourthcolumn),r.a.createElement("th",null,e.fifthcolumn),r.a.createElement("th",null,e.sixthcolumn),r.a.createElement("th",null,e.seventhcolumn),r.a.createElement("th",null,e.eigthcolumn)))};var J=function(e){return r.a.createElement("tr",null,r.a.createElement("td",null,e.firstcolumn),r.a.createElement("td",null,e.secondcolumn),r.a.createElement("td",null,e.thirdcolumn),r.a.createElement("td",null,e.fourthcolumn),r.a.createElement("td",null,e.fifthcolumn),r.a.createElement("td",null,e.sixthcolumn),r.a.createElement("td",null,e.seventhcolumn),r.a.createElement("td",null,e.eigthcolumn))},q=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){var e;return Object(o.a)(this,a),(e=t.call(this)).fetchData=function(){var t=Object(f.a)(p.a.mark((function t(a){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,g.a.get("http://localhost:8080/winsoft/BCCI/weather/".concat(a)).then((function(t){var a,n;console.warn(t.data),console.warn(t.data.length),e.setState({prediction:t.data,resposelength:t.data.length}),console.log(Object.keys(t.data[0].predictionData)),Object.keys(t.data[0].predictionData).forEach((function(e){a=t.data[0].predictionData[e],Object.keys(a).forEach((function(e){n=a[e],console.log("weather cat"+e)})),console.log("inside console : "+a),console.log("console : "+n)}))})).catch((function(e){e.response&&(console.log(e.response.status),console.log(e.response.header),window.alert("No matches found in this series = "+e.response.status))}));case 2:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),e.handleChange=function(){var t=Object(f.a)(p.a.mark((function t(a){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,e.setState({value:a.target.value});case 2:console.log("selected Series  = "+e.state.value),e.fetchData(e.state.value);case 4:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),e.getWeatherCat=function(e){var t,a;return Object.keys(e.predictionData).forEach((function(n){t=e.predictionData[n],Object.keys(t).forEach((function(e){a=e}))})),a},e.getValue=function(e){var t,a;return Object.keys(e.predictionData).forEach((function(n){t=e.predictionData[n],Object.keys(t).forEach((function(e){a=t[e]}))})),a},e.fetchImageUrl=function(e){return console.log("in image : "+Object.keys(e.predictionData)),"http://openweathermap.org/img/w/"+Object.keys(e.predictionData)+".png"},e.state={series:[],prediction:[],resposelength:"0",weatherCat:"",weatherPerc:"",perc:"",iconId:""},e.handleChange=e.handleChange.bind(Object(y.a)(e)),e.getValue=e.getValue.bind(Object(y.a)(e)),e}return Object(u.a)(a,[{key:"componentDidMount",value:function(){var e=this;fetch("http://localhost:8080/winsoft/BCCI/series").then((function(t){t.json().then((function(t){console.warn(t),e.setState({series:t})}))}))}},{key:"render",value:function(){var e=this;return r.a.createElement("div",null,r.a.createElement("div",{className:"container"},r.a.createElement("select",{value:this.state.value,onChange:this.handleChange},this.state.series.map((function(e){return r.a.createElement(j,{key:e.series_id,value:e.series_id,name:e.series_name})})))),r.a.createElement("div",null,r.a.createElement("table",null,r.a.createElement(A,{firstcolumn:"Series Name",secondcolumn:"Team 1",thirdcolumn:"Team 2",fourthcolumn:"City Name",fifthcolumn:"Match Date",sixthcolumn:"Weather Condition",seventhcolumn:"prediction Percentage",eigthcolumn:"weather photo"}),r.a.createElement("tbody",null,this.state.prediction.map((function(t){return r.a.createElement(J,{key:t.match_id,firstcolumn:t.series_name,secondcolumn:t.team1,thirdcolumn:t.team2,fourthcolumn:t.city,fifthcolumn:t.match_date,sixthcolumn:e.getWeatherCat(t),seventhcolumn:e.getValue(t),eigthcolumn:r.a.createElement("img",{src:e.fetchImageUrl(t),alt:"weather"})})}))))))}}]),a}(r.a.Component),z=function(e){Object(i.a)(a,e);var t=Object(h.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(u.a)(a,[{key:"render",value:function(){return r.a.createElement(m.b,{history:T},r.a.createElement(m.c,null,r.a.createElement(m.a,{path:"/",exact:!0,component:P}),r.a.createElement(m.a,{path:"/MatchMasterPanel",exact:!0,component:W}),r.a.createElement(m.a,{path:"/SeriesMasterPanel",exact:!0,component:G}),r.a.createElement(m.a,{path:"/GetAllSeries",exact:!0,component:C}),r.a.createElement(m.a,{path:"/AllMatch",exact:!0,component:w}),r.a.createElement(m.a,{path:"/GetMatchesBySeriesId",exact:!0,component:O}),r.a.createElement(m.a,{path:"/CreateSeries",exact:!0,component:k}),r.a.createElement(m.a,{path:"/CreateMatchBySeries",exact:!0,component:S}),r.a.createElement(m.a,{path:"/UpdateSeries",exact:!0,component:N}),r.a.createElement(m.a,{path:"/UpdateMatch",exact:!0,component:B}),r.a.createElement(m.a,{path:"/Prediction",exact:!0,component:q})))}}]),a}(n.Component);s.a.render(r.a.createElement(l.a,null,r.a.createElement(z,null)),document.getElementById("root"))}},[[34,1,2]]]);
//# sourceMappingURL=main.dfbccf0b.chunk.js.map