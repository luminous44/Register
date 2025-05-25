 let form = document.getElementById("registration");
  let loader = document.getElementById("loader");
  let card = document.getElementById("card");

  form.addEventListener("submit", function (event) {
 event.preventDefault();
 
    card.style.display = "none";
    loader.style.display = "block";

    
    
  });


