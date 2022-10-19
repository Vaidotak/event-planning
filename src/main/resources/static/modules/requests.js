const API_BASE_URL = "http://localhost:8080";

export const getAllUsers = async () => {
  const response = await fetch(`${API_BASE_URL}/user-registration`);
  const users = await response.json();
  return users;
};

export const updateUser = async (user, id) => {
  await fetch(`${API_BASE_URL}/user-registration/${id}`, {
    method: "PATCH",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  });

  alert(`[User ${id}] successfully updated`);
};

export const deleteUserById = async (id) => {
  await fetch(`${API_BASE_URL}/user-registration/${id}`, {
    method: "DELETE",
  });
  alert(`[User ${id}] successfully deleted`);
};

export const saveUser = async (user) => {
  await fetch(`${API_BASE_URL}/user-registration`, {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  });
  alert(`User successfully added`);
  window.location.reload();
};
