import { renderUserTable } from "./modules/user-table.js";
import { handleUserFormSubmit } from "./modules/add-user.js";


(async () => {
  await renderUserTable();
  await handleUserFormSubmit();
})();