import { VIEW_PRODUCT } from "./constant";

export const viewData = (data = [], action) => {
  switch (action.type) {
    case VIEW_PRODUCT:
      // console.log("action data",action.data)
      return action.data;
    default:
      return data;
  }
};
