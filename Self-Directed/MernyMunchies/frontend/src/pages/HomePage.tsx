import landingImage from "../assets/landing.png";
import appDownload from "../assets/appDownload.png";

export default function HomePage() {
  return (
    <div className="flex flex-col gap-12">
        <div className="bg-white rounded-lg shadow-md py-8 flex flex-col gap-5 text-center -mt-16">
            <h1 className="text-5xl font-bold tracking-tight text-orange-600">Welcome to Merny Munchies!</h1>
            <span className="text-xl">The best place to find all your favorite munchies!</span>
        </div>
        <div className="grid md:grid-cols-2 gap-5">
            <img src={landingImage}></img>
            <div className="flex flex-col items-center justify-center gap-4 text-center">
                <span className="font-bold text-3xl tracking-tighter">
                    Order takaway faster than ever!
                </span>
                <img src={appDownload}></img>
                <span>
                    Coming soon!
                </span>
                
            </div>
        </div>
    </div>
  )
}
