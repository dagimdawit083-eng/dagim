class CommonHeader extends HTMLElement {
  connectedCallback() {
    this.innerHTML = `
      <nav style="text-align: center; ">
        <a href="index.html">HOME</a>
        <a href="about.html">ABOUT</a>
        <a href="educationalbackground.html">EDUCATIONAL BACKGROUND</a>
        <a href="skills.html">SKILLS</a>
        <a href="project.html">PROJECT</a>
        <a href="contact.html">CONTACT</a>
      </nav>
    `;
  }
}

class CommonFooter extends HTMLElement {
  connectedCallback() {
    this.innerHTML = `
      <footer style="margin-top: 10px;">
        <p style="text-align: center; color:white;" >&copy; 2025 Dagim Dawit. All rights reserved.</p><br>
      </footer>
    `;
  }
}



    


customElements.define('common-header', CommonHeader);
customElements.define('common-footer', CommonFooter);

function showWelcomeMessage() {
  if (!localStorage.getItem('welcomeShown')) {
    alert("Welcome to Dagim's personal website!");
    localStorage.setItem('welcomeShown', 'true');
  }
}

// Call the function when the page loads
showWelcomeMessage();