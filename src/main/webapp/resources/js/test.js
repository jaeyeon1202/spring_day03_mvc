function test(){
alert("test");
}

window.onload = () => {
		const btn = document.getElementById("btn")
		btn.addEventListener("click", test);
	}

