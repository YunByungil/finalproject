<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/test.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script>
//Elements
const el = {
  signUpHome: document.getElementById('sign-up'),
  signInHome: document.getElementById('sign-in'),
  btnHome: document.querySelector('.btn-back'),
  pageMain: document.querySelector('.main'),
  pageHome: document.querySelector('.home'),
  pageSignUp: document.querySelector('.sign-up'),
  formArea: document.querySelector('.form-area'),
  sideSignLeft: document.querySelector('.signup-left'),
  sideSignRight: document.querySelector('.signup-right'),
  formSignUp: document.querySelector('.form-area-signup'),
  formSignIn: document.querySelector('.form-area-signin'),
  linkUp: document.querySelector('.link-up'),
  linkIn: document.querySelector('.link-in'),
  btnSignUp: document.querySelector('.btn-up'),
  btnSignIn: document.querySelector('.btn-in'),
  labels: document.getElementsByTagName('label'),
  inputs: document.getElementsByTagName('input'),
};


// ADD Events
// Show the page Sign Up
el.signUpHome.addEventListener('click', function(e) {
  showSign(e, 'signup');
});
el.linkUp.addEventListener('click', function(e) {
  showSign(e, 'signup');
});

// Show the page sign in
el.signInHome.addEventListener('click', function(e) {
  showSign(e, 'signin');
});
el.linkIn.addEventListener('click', function(e) {
  showSign(e, 'signin');
});
el.btnSignUp.addEventListener('click', function(e) {
  showSign(e, 'signin');
});

// Show the page Home
el.btnHome.addEventListener('click', showHome);


// Functions Events
// function to show screen Home
function showHome(event) {
  
  
  setTimeout(function() {
    el.sideSignLeft.style.padding = '0';
    el.sideSignLeft.style.opacity = '0';
    el.sideSignRight.style.opacity = '0';
    el.sideSignRight.style.backgroundPositionX = '235%';

    el.formArea.style.opacity = '0';
    setTimeout(function() {
      el.pageSignUp.style.opacity = '0';
      el.pageSignUp.style.display = 'none';
      for (input of el.inputs)  {
        input.value = '';
      }
    }, 900);

  }, 100);

  setTimeout(function() {
    el.pageHome.style.display = 'flex';
  },1100);
  
  setTimeout(function() {
    el.pageHome.style.opacity = '1';
  }, 1200);

}
// function to show screen Sign up/Sign in
function showSign(event, sign) {

  if (sign === 'signup') {
    el.formSignUp.style.display = 'flex';
    el.formSignIn.style.opacity = '0';
    setTimeout(function() {
      el.formSignUp.style.opacity = '1';
    }, 100);
    el.formSignIn.style.display = 'none';

  } else {
    el.formSignIn.style.display = 'flex';
    el.formSignUp.style.opacity = '0';
    setTimeout(function() {
      el.formSignIn.style.opacity = '1';
    }, 100);
    el.formSignUp.style.display = 'none';
  }

  el.pageHome.style.opacity = '0';
  setTimeout(function() {
    el.pageHome.style.display = 'none';
  }, 700);
  
  setTimeout(function() {
    el.pageSignUp.style.display = 'flex';
    el.pageSignUp.style.opacity = '1';
    
    setTimeout(function() {
      el.sideSignLeft.style.padding = '20px';
      el.sideSignLeft.style.opacity = '1';
      el.sideSignRight.style.opacity = '1';
      el.sideSignRight.style.backgroundPositionX = '230%';

      el.formArea.style.opacity = '1';
    }, 10);

  }, 900);
}

// Behavior of the inputs and labels
for (input of el.inputs) {
  console.log(input)
  input.addEventListener('keydown', function() {
    this.labels[0].style.top = '10px';
  });
  input.addEventListener('blur', function() {
    if (this.value === '') {
      this.labels[0].style.top = '25px';
    }
  })
}

</script>
</head>
<body>

<main class="main">
  <section class="home">
    <h1>Welcome to the <span>Destiny</span></h1>
    <button id="sign-up" class="btn">Sign Up</button>
    <button id="sign-in" class="btn">Sign In</button>
    <p><a class="link-copy" href="http://collectui.com/designers/dnes/sign-up" target="_blank">©Copyright 2020</a></p>
  </section>

  <section class="sign-up">
    <article class="signup-left">
      <h1>Destiny</h1>
      <div class="wc_message">
        <h3>Let's Kick Now!</h3>
        <p>It's Easy and takes less then 30 seconds.</p>
      </div>
      <div class="btn-back">
        <i class="fas fa-2x fa-angle-left angle-left-color"></i>
        HOME
      </div>
    </article>

    <article class="form-area">
      <!-- Form area Sign Up -->
      <div class="organize-form form-area-signup">
        <h2>SIGN UP</h2>
        <form class="form">
          <div class="form-field">
            <label for="name">Name</label>
            <input type="text" id="name" />
          </div>

          <div class="form-field">
            <label for="email">Email</label>
            <input type="text" id="email" />
          </div>

          <div class="form-field">
            <label for="password">Password</label>
            <input type="text" id="password" />
          </div>

          <button class="btn-sign btn-up">Sign Up</button>
        </form>
        <p>Have an account? <a href="#" class="link-in">Sign In</a></p>

      </div>

      <!-- Form area Sign In -->
      <div class="organize-form form-area-signin">
        <h2>SIGN IN</h2>
        <form class="form">
          <div class="form-field">
            <label for="email-in">Email</label>
            <input type="text" name="email_in" id="email-in" />
          </div>

          <div class="form-field">
            <label for="password-in">Password</label>
            <input type="text" name="password_in" id="password-in" />
          </div>

          <button class="btn-sign btn-in">Sign In</button>
        </form>
        <p>Haven't an account? <a href="#" class="link-up">Sign Up</a></p>
      </div>
    </article>

    <article class="signup-right">
      <i class="fas fa-2x fa-bars bars-style"></i>
      <p><a class="link-copy" href="http://collectui.com/designers/dnes/sign-up" target="_blank">©Copyright 2020</a></p>

    </article>
  </section>
</main>

</body>
</html>