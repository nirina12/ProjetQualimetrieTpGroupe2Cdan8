const btnAjoutTache = document.querySelector("#btnajoutTache");

const btnModal = document.querySelector("#btnModal");
const headerModal = document.querySelector("#exampleModalLabel");
const bodyModal = document.querySelector("#modalBodyTache");
const idTacheModal = document.querySelector("#inputTextIdTache");
const inputTextnomtache = document.querySelector("#inputTextnomtache");
const titreinputModal = document.querySelector("#titreinputModal");
const descriptiontextAreaTacheModal = document.querySelector(
  "#descriptiontextAreaTacheModal"
);

const btnActionPost = document.querySelectorAll("tr td button");
const btnModifier = document.querySelectorAll(".btnModifier");
const btnSupprimer = document.querySelectorAll("tr td button.btnSupprimer");

var statusTacheModal = document.querySelector("#checkStatusTache");

const labelSuppr = document.querySelector("#confSuppr");

const divStatusTache = document.getElementById("divStatusTache");

const ajoutModifier = document.querySelector("#AjoutModifier");
const supprTache = document.querySelector("#SupprTache");
const labelStatusTache = document.querySelector("#labelStatusTache");

const ligneTable = document.getElementsByName("ligneTable");

const currentUser = document.querySelector("#currentUser");

/* INIT LIST TACHES  */
$.ajax({
  url: "/api/tache/list_tache",
  type: "GET",
  dataType: "json",
  success: function (data) {
    //console.log(data[0])
    var jsonData = data;
    $("#tableContent").empty();
    var columnCount = 3; // Par défaut, 3 colonnes
    if ($(window).width() < 768) {
      // Pour les écrans plus petits que 768px, utiliser une seule colonne
      columnCount = 1;
    }
    function generateBootstrapTable(data) {
      var table = $("<table>").addClass("table table-striped");

      // Entête de la table
      var thead = $("<thead>").appendTo(table);
      var headerRow = $("<tr>").appendTo(thead);
      $("<th>").text("Title").appendTo(headerRow);
      $("<th>").text("Description").appendTo(headerRow);
      $("<th>").text("Status").appendTo(headerRow);
      $("<th>").text("Actions").appendTo(headerRow);

      // Corps de la table
      var tbody = $("<tbody>").appendTo(table);
      $.each(data, function (index, item) {
        var row = $("<tr>").appendTo(tbody);
        var status = item.status; // Supposons que vous avez une variable contenant la valeur de l'état
        var checkbox = $("<input type='checkbox' />");
        // checkbox.addClass("checkStatusTache")
        if (status) {checkbox.prop("checked", true);}
        $("<td>").text(item.title).appendTo(row);
        $("<td>").text(item.description).appendTo(row);
        $("<td>").append(checkbox).appendTo(row);
        $("<td>").text(item.tache_id).appendTo(row).attr("hidden","hidden");
        
        // row.addClass("table-secondary")
        row.css("background-color", "gray")

        checkbox.on("change", function(event){
            event.preventDefault();
            
            var data = {
                tache_id: row.find("td:nth-child(4)").text(),
                status: row.find("td:nth-child(3)").find("input[type='checkbox']").prop("checked"),
              };
              console.log(data);
              var xhr = new XMLHttpRequest();
              xhr.open("PUT", "/api/tache/updateEtatTache", true);
              xhr.setRequestHeader("Content-Type", "application/json");
              xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                  //console.log(xhr.responseText);
                }
              };
              xhr.send(JSON.stringify(data));
        })
        // Colonne d'action
        var actionCell = $("<td>").appendTo(row);
        var modifierBtn = $("<a>")
          .addClass("btn btn-primary me-2 btnModifier")
          .text("Modifier")
          .attr("href", "/update/" + item.tache_id) // Remplacez "lien_de_modification" par votre URL de modification
          .attr("data-bs-toggle", "modal")
          .attr("data-bs-target", "#staticBackdrop")
          .appendTo(actionCell);

        modifierBtn.on("click", function (event) {
          event.preventDefault();
          var row = $(this).closest("tr");

          // Récupérer les valeurs des éléments de la ligne
          titreinputModal.value = row.find("td:nth-child(1)").text();
          descriptiontextAreaTacheModal.value = row.find("td:nth-child(2)").text();
          idTacheModal.value = row.find("td:nth-child(4)").text();
          divStatusTache.hidden = false;
          ajoutModifier.hidden = false;
          supprTache.hidden = true;
          // Votre code à exécuter lorsque le lien est cliqué
          // console.log(checkBoxEtatTache)
          changeModalAction("Modifier tâche");
        });

        var supprimerBtn = $("<a>")
          .addClass("btn btn-danger")
          .text("Supprimer")
          .attr("href", "/delete/" + item.tache_id) // Remplacez "lien_de_suppression" par votre URL de suppression
          .attr("data-bs-toggle", "modal")
          .attr("data-bs-target", "#staticBackdrop")
          .appendTo(actionCell);
        
        supprimerBtn.on("click", function(event){
            event.preventDefault();
            ajoutModifier.hidden = true;
            supprTache.hidden = false;
            labelSuppr.innerHTML = row.find("td:nth-child(1)").text();
            idTacheModal.value = row.find("td:nth-child(4)").text();

            changeModalAction("Supprimer tâche");
        })
      });

      return table;
    }

    var tableElement = generateBootstrapTable(jsonData);
    $(".container").append(tableElement);
  },
});

btnModal.onclick = () => {
  switch (btnModal.value) {
    case "Ajouter tâche":
      var data = {
        title: titreinputModal.value,
        description: descriptiontextAreaTacheModal.value,
      };

      var xhr = new XMLHttpRequest();
      xhr.open("POST", "/api/tache/add_tache", true);
      xhr.setRequestHeader("Content-Type", "application/json");
      xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
          console.log(xhr.responseText);
        }
      };
      xhr.send(JSON.stringify(data));
      location.reload(true);
      break;
    case "Supprimer tâche":
      console.log(idTacheModal.value);
      var data = {
        tache_id: idTacheModal.value,
      };

      var xhr = new XMLHttpRequest();
      xhr.open("DELETE", "/api/tache/delete_tache/" + idTacheModal.value, true);
      xhr.setRequestHeader("Content-Type", "application/json");
      xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
          console.log(xhr.responseText);
        }
      };
      xhr.send(JSON.stringify(data));
      location.reload(true);
      break;
    case "Modifier tâche":
      //console.log(statusTacheModal.checked);
      var data = {
        tache_id: idTacheModal.value,
        title: titreinputModal.value,
        description: descriptiontextAreaTacheModal.value,
        status: statusTacheModal.checked,
      };

      var xhr = new XMLHttpRequest();
      xhr.open("PUT", "/api/tache/update_tache", true);
      xhr.setRequestHeader("Content-Type", "application/json");
      xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
          console.log(xhr.responseText);
        }
      };
      xhr.send(JSON.stringify(data));
      location.reload(true);
      break;
    default:
      console.log("mauvais choix");
      break;
  }
};

//statestatusTacheModal()
function statestatusTacheModal() {
  if (statusTacheModal.checked == true) {
    statusTacheModal.value = "true";
    labelStatusTache.innerHTML = "Terminé";

    modifierEtatTache(statusTacheModal);
  } else {
    statusTacheModal.value = "false";
    labelStatusTache.innerHTML = "Non Terminé";
    modifierEtatTache(statusTacheModal);
  }
}

statusModalChange();

// function initiation status modal
function statusModalChange() {
  if (statusTacheModal) {
    statusTacheModal.onchange = () => {
      statusTacheModal.checked == true
        ? (statusTacheModal.value = "true")
        : (statusTacheModal.value = "false");
      //console.log("changed" + statusTacheModal.value)
      statestatusTacheModal();
    };
  }
}

for (let i = 0; i < btnModifier.length; i++) {
  btnModifier[i].onclick = () => {
    //console.log("modifier")
    modifierOnclick(btnModifier[i]);
  };
}

for (let i = 0; i < btnSupprimer.length; i++) {
  btnSupprimer[i].onclick = () => {
    supprimerOnclick(btnSupprimer[i]);
  };
}

btnAjoutTache.onclick = () => {
  btnModal.value = "Ajouter tâche";
  headerModal.textContent = "Ajouter tâche";
  //   bodyModal.textContent = "Ajouter tâche";
  //inputTextnomtache.value = "";
  divStatusTache.hidden = true;
  ajoutModifier.hidden = false;
  supprTache.hidden = true;
};

function supprimerOnclick(e) {
  var rowData = e.parentElement.parentElement.children;
  ajoutModifier.hidden = true;
  supprTache.hidden = false;
  labelSuppr.innerHTML = rowData[1].innerHTML.trim();
  idTacheModal.value = rowData[0].innerHTML;
  changeModalAction("Supprimer tâche");
}
function modifierOnclick(e) {
  var rowData = e.parentElement.parentElement.children;
  divStatusTache.hidden = false;
  ajoutModifier.hidden = false;
  supprTache.hidden = true;
  //var statustache = rowData[1].querySelector('input[type="checkbox"]').checked
  titreinputModal.value = rowData[1].innerHTML.trim();
  descriptiontextAreaTacheModal.value = rowData[2].innerHTML.trim();
  statestatusTacheModal();
  idTacheModal.value = rowData[0].innerHTML;

  //console.log(inputTextnomtache.value + idTacheModal.value + statustache)
  changeModalAction("Modifier tâche");
}

function modifierEtatTache(e) {
  var rowData = e.parentElement.parentElement.children;
  var data = {
    tache_id: rowData[0].innerHTML.trim(),
    status: rowData[3].querySelector('input[type="checkbox"]').checked,
  };

  var xhr = new XMLHttpRequest();
  xhr.open("PUT", "/api/tache/updateEtatTache", true);
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      //console.log(xhr.responseText);
    }
  };
  xhr.send(JSON.stringify(data));
}

function changeModalAction(action) {
  btnModal.value = action;
  headerModal.textContent = action;
  //bodyModal.textContent = action;
}
