  export const getAge = (dateString) => {
    const today = new Date();
    const birthDate = new Date(dateString);  
    const yearsDifference = today.getFullYear() - birthDate.getFullYear();
  
    if (
      today.getMonth() < birthDate.getMonth() ||
      (today.getMonth() === birthDate.getMonth() && today.getDate() < birthDate.getDate())
    ) {
      return yearsDifference - 1;
    }
  
    return yearsDifference;
  };