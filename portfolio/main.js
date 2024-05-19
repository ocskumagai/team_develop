var header = document.querySelector(".container");
var showHeaderAt = 850;

// yの値がっ高さ800になったらヘッダーを表示
window.addEventListener("scroll", function () {
  if (windosw.scrollY > showHeaderAt) {
    header.classList.add("visible");
    header.classList.remove("wrapper");
  } else {
    header.classList.remove("visible");
    header.classList.add("wrapper");
  }
});
