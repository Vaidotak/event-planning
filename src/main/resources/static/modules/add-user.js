import { saveUser } from "./requests.js";
import { renderUserTable } from "./user-table.js";

export const handleUserFormSubmit = async () => {
  const form = document.getElementById("form");
  form.addEventListener("submit", (e) => {
    e.preventDefault();
    submitUser(
      form.firstName.value,
      form.lastName.value,
      form.email.value,
      form.birth.value
    );
  });
};

const submitUser = async (firstName, lastName, email, birth) => {
  const user = { firstName, lastName, email, birth };
  await saveUser(user);
  await renderUserTable();
};
