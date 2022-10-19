import { getAllUsers, updateUser, deleteUserById } from "./requests.js";
import { getAge } from ".//birth-to-age.js";

export const renderUserTable = async () => {
  const users = await getAllUsers();
  if (document.getElementById("userTable")) {
    document.getElementById("userTable").remove();
  }
  const table = document.createElement("table");
  table.id = "userTable";
  table.className = "w3-table-all w3-card-4 w3-hoverable";

  renderUserTableHeaders(table);
  const tbody = document.createElement("tbody");
  users.forEach((user) => {
    renderUserTableRow(tbody, user);
  });

  table.appendChild(tbody);
  document.getElementById("userContainer").appendChild(table);
};

const renderTableCell = (innerText, className) => {
  const td = document.createElement("td");
  if (innerText) {
    td.innerText = innerText;
  }
  if (className) {
    td.className = className;
  }
  return td;
};

const renderTableHeader = (innerText) => {
  const th = document.createElement("th");
  th.innerText = innerText;
  th.className = "w3-blue";
  return th;
};

const renderActionButtons = (actionsCell, id) => {
  const editButton = document.createElement("button");
  editButton.innerText = "Edit";
  editButton.className = "w3-small w3-button w3-blue w3-hover-pink editButton";
  editButton.addEventListener("click", () => {
    handleEdit(id);
  });

  const deleteButton = document.createElement("button");
  deleteButton.innerText = "Delete";
  deleteButton.className =
    "w3-small w3-button w3-red w3-hover-purple deleteButton";
  deleteButton.addEventListener("click", () => {
    handleDelete(id);
  });

  actionsCell.append(editButton, deleteButton);
};

const handleEdit = async (id) => {
  const tr = document.getElementById(`user-${id}`);

  const firstNameCell = tr.querySelector(".firstNameCell");
  const firstNameInput = document.createElement("input");
  firstNameInput.type = "text";
  firstNameInput.value = firstNameCell.innerText;
  firstNameCell.innerText = "";
  firstNameCell.appendChild(firstNameInput);

  const lastNameCell = tr.querySelector(".lastNameCell");
  const lastNameInput = document.createElement("input");
  lastNameInput.type = "text";
  lastNameInput.value = lastNameCell.innerText;
  lastNameCell.innerText = "";
  lastNameCell.appendChild(lastNameInput);

  const emailCell = tr.querySelector(".emailCell");
  const emailInput = document.createElement("input");
  emailInput.type = "text";
  emailInput.value = emailCell.innerText;
  emailCell.innerText = "";
  emailCell.appendChild(emailInput);

  const birthCell = tr.querySelector(".birthCell");
  const birthInput = document.createElement("input");
  birthInput.type = "text";
  birthInput.value = birthCell.innerText;
  birthCell.innerText = "";
  birthCell.appendChild(birthInput);

  const actionsCell = tr.querySelector(".actionsCell");
  actionsCell.querySelector(".editButton").remove();
  actionsCell.querySelector(".deleteButton").remove();

  const saveButton = document.createElement("button");
  saveButton.innerText = "Save";
  saveButton.className =
    "w3-small w3-button w3-pale-red w3-hover-purple saveButton";
  saveButton.addEventListener("click", () => {
    handleUpdate(id);
  });

  const cancelButton = document.createElement("button");
  cancelButton.innerText = "Cancel";
  cancelButton.className =
    "w3-small w3-button w3-light-blue w3-hover-purple cancelButton";
  cancelButton.addEventListener("click", () => {
    window.location.reload();
  });

  actionsCell.append(saveButton, cancelButton);
};

const handleUpdate = async (id) => {
  const tr = document.getElementById(`user-${id}`);
  const firstNameCell = tr.querySelector(".firstNameCell");
  const firstNameInput = firstNameCell.querySelector("input");

  const lastNameCell = tr.querySelector(".lastNameCell");
  const lastNameInput = lastNameCell.querySelector("input");

  const emailCell = tr.querySelector(".emailCell");
  const emailInput = emailCell.querySelector("input");

  const birthCell = tr.querySelector(".birthCell");
  const birthInput = birthCell.querySelector("input");

  const user = {
    firstName: firstNameInput.value,
    lastName: lastNameInput.value,
    email: emailInput.value,
    birth: birthInput.value,
  };

  await updateUser(user, id);
  await renderUserTable();
};

const handleDelete = async (id) => {
  await deleteUserById(id);
  await renderUserTable();
};

const renderUserTableRow = (tbody, user) => {
  const tr = document.createElement("tr");
  tr.id = `user-${user.id}`;
  const firstNameCell = renderTableCell(user.firstName, "firstNameCell");
  const lastNameCell = renderTableCell(user.lastName, "lastNameCell");
  const emailCell = renderTableCell(user.email, "emailCell");
  const birthCell = renderTableCell(getAge(user.birth), "birthCell");
  const actionsCell = renderTableCell(undefined, "actionsCell");
  renderActionButtons(actionsCell, user.id);

  tr.append(firstNameCell, lastNameCell, emailCell, birthCell, actionsCell);

  tbody.appendChild(tr);
};

const renderUserTableHeaders = (table) => {
  const tr = document.createElement("tr");
  const thead = document.createElement("thead");
  tr.appendChild(thead);
  const firstNameTh = renderTableHeader("Name");
  const lastNameTh = renderTableHeader("Surname");
  const emailTh = renderTableHeader("Email");
  const birthTh = renderTableHeader("Age");
  const actionsTh = renderTableHeader("Actions");

  thead.append(firstNameTh, lastNameTh, emailTh, birthTh, actionsTh);
  table.appendChild(thead);
};
