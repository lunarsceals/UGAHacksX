"use client";
import { Button } from "./Button";

interface formProps {
  handleSubmit?: () => void;
}

export const InputForm = ({ handleSubmit }: formProps) => {
  return (
    <div className="flex flex-1 font-bold md:max-w-60 w-full">
      <form className="flex w-full flex-col gap-8" onSubmit={handleSubmit}>
        {/* Form Input */}
        <div>
          <h1>Initial Amount</h1>
          <input type="text" className="rounded-sm p-1 border-2 w-full" />
        </div>
        <div>
          <h1>APR/APY</h1>
          <input type="text" className="rounded-sm p-1 border-2 w-full" />
        </div>
        <div>
          <h1>Monthly Contribution</h1>
          <input type="text" className="rounded-sm p-1 border-2 w-full" />
        </div>
        <div>
          <h1>
            Inflation <span className="text-red-700">*optional*</span>
          </h1>
          <input type="text" className="rounded-sm p-1 border-2 w-full" />
        </div>

        {/* Form Buttons */}
        <div className="flex items-center gap-6 flex-col">
          <Button
            text="Clear"
            type="reset"
            className=" w-full border-2 bg-white py-3 text-black transition ease-in-out hover:border-red-500 hover:text-red-500"
          />
          <Button
            text="Calculate"
            type="submit"
            className="w-full border-slate-500 py-3 text-white transition ease-in-out hover:border-2 hover:border-black hover:bg-green-400 hover:text-black bg-teal-800 border-2"
          />
        </div>
      </form>
    </div>
  );
};
