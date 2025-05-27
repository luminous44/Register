const form = document.getElementById("registration");
const loader = document.getElementById("loader");
const card = document.getElementById("card");
const message = document.getElementById("msg");


 form.addEventListener("submit",function(event){
     //event.preventDefault();
     loader.style.display = "block";
     card.style.display = "none";
     message.textContent = "";
     
     const registration = async()=> { 
         
         let response = await fetch("Registration");
         let data = response.json();
         console.log(data);
         
     };
    
 });
   


